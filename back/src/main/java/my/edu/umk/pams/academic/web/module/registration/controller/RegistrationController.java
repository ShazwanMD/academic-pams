package my.edu.umk.pams.academic.web.module.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.registration.service.RegistrationService;
import my.edu.umk.pams.academic.web.module.registration.transformer.RegistrationTransformer;
import my.edu.umk.pams.academic.web.module.registration.vo.UserRegistration;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private RegistrationTransformer registrationTransformer;

	private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody UserRegistration registration) {

		AdUser user = new AdUserImpl();
		user.setUsername(registration.getEmail());
		user.setEmail(registration.getEmail());
		user.setRealName(registration.getName());
		user.setPassword(registration.getPassword());
		user.setEnabled(false);
		user.setLocked(true);

		if (identityService.isUserExists(user.getUsername())) {
			throw new IllegalArgumentException("You have already register");
		}

		AdStudent applicant = new AdStudentImpl();
		applicant.setIdentityNo(registration.getIdentityNo());
		applicant.setName(registration.getName());
		applicant.setEmail(registration.getEmail());

		registrationService.registerUser(user, applicant);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/verifyUser/{token}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> verifyUser(@PathVariable String token) {
		registrationService.verifyUser(token);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@RequestMapping(value = "/forgetPassword/{email:.+}", method = RequestMethod.GET)
	public ResponseEntity<String> forgetPassword(@PathVariable String email) {
		LOG.debug("My email value is: " + email);
		if (email == null)
			LOG.debug("Email is null");

		AdUser user = identityService.findUserByEmail(email);

		if (user == null)
			LOG.debug("UserA is null");
		LOG.debug("user check ", user);

		LOG.debug("email", email);
		LOG.debug("user", user);

		if ((identityService.findUserByEmail(email) == null))
			throw new IllegalArgumentException("Invalid email!");

		registrationService.forgetPassword(user);
		LOG.debug("after forget");

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}
