package my.edu.umk.pams.academic.registration.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.edu.umk.pams.academic.identity.dao.AdUserDao;
import my.edu.umk.pams.academic.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.registration.dao.AdUserVerificationDao;
import my.edu.umk.pams.academic.registration.model.AdUserVerification;
import my.edu.umk.pams.academic.registration.model.AdUserVerificationImpl;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.model.AdEmailQueue;
import my.edu.umk.pams.academic.system.model.AdEmailQueueImpl;
import my.edu.umk.pams.academic.system.model.AdEmailQueueStatus;
import my.edu.umk.pams.academic.system.service.SystemService;

@Transactional
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger LOG = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	public static final int ONE_WEEK = 60 * 24 * 7;

	@Autowired
	private AdUserVerificationDao userVerificationDao;

	@Autowired
	private AdUserDao userDao;

	@Autowired
	private SystemService systemService;
	@Autowired
	private IdentityService identityService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void registerUser(AdUser user, AdStudent student) {
		SecurityContext sc = loginAsSystem();

		user.setEnabled(false);
		user.setLocked(true);

		// save user and refresh
		identityService.saveUser(user);
		try {
			AdGroup group = identityService.findGroupByName("GRP_APCN");
			AdPrincipal principal = identityService.findPrincipalByName(user.getName());
			System.out.println("group :" + group);
			identityService.addGroupMember(group, principal);
		} catch (RecursiveGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().refresh(user);

		// save applicant
		identityService.saveStudent(student);
		sessionFactory.getCurrentSession().refresh(student);

		// link user and applicant
		user.setActor(student);
		identityService.updateUser(user);

		// generate token
		String token = generateToken();
		AdUserVerification verification = new AdUserVerificationImpl();
		verification.setExpiryDate(calculateExpiryDate(ONE_WEEK));
		verification.setToken(token);
		verification.setUser(user);
		userVerificationDao.save(verification, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

		// send email notification
		String applicationUrl = systemService.findConfigurationByKey("application.url").getValue();
		AdEmailQueue email = new AdEmailQueueImpl();
		String subject = "Email verification";
		String body = "Please verify your email address upon 7 days from your registration day by clicking this url : "
				+ applicationUrl + "/verification/" + token;
		// verification.getToken();
		email.setTo(user.getEmail());
		email.setSubject(subject);
		email.setBody(body);
		// method send email
		email.setCode("EQ/" + System.currentTimeMillis());
		email.setQueueStatus(AdEmailQueueStatus.QUEUED);
		systemService.saveEmailQueue(email);

		// logout
		logoutAsSystem(sc);

	}

	@Override
	public void verifyUser(String token) {
		SecurityContext sc = loginAsSystem();
		AdUserVerification verification = userVerificationDao.findByToken(token);
		AdUser user = verification.getUser();
		user.setEnabled(true);
		identityService.updateUser(user);
		logoutAsSystem(sc);

	}

	@Override
	public void forgetPassword(AdUser user) {
		SecurityContext sc = loginAsSystem();
		if (user == null)
			LOG.debug("UserB is null");
		if (user.getEmail() == null)
			LOG.debug("Email is null");
		String applicationUrl = systemService.findConfigurationByKey("application.url").getValue();
		AdEmailQueue email = new AdEmailQueueImpl();
		String subject = "Password Recovery";
		String body = "Your password is : " + user.getPassword()
				+ ". You are encourage to change your password. Please click the given url to login. " + applicationUrl
				+ "/login/";
		email.setTo(user.getEmail());
		email.setSubject(subject);
		email.setBody(body);
		email.setCode("EQ/" + System.currentTimeMillis());
		email.setQueueStatus(AdEmailQueueStatus.QUEUED);
		systemService.saveEmailQueue(email);
		logoutAsSystem(sc);

	}

	@Override
	public boolean isUserExists(String username) {
		return identityService.isUserExists(username);
	}

	@Override
	public String generateToken() {
    	
    	String token = UUID.randomUUID().toString();
    	
    	return token;
	}

	private SecurityContext loginAsSystem() {
		SecurityContext savedCtx = SecurityContextHolder.getContext();
		AdAutoLoginToken authenticationToken = new AdAutoLoginToken("system");
		Authentication authed = authenticationManager.authenticate(authenticationToken);
		SecurityContext system = new NonSerializableSecurityContext();
		system.setAuthentication(authed);
		SecurityContextHolder.setContext(system);
		return savedCtx;
	}

	private void logoutAsSystem(SecurityContext context) {
		SecurityContextHolder.setContext(context);
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}
