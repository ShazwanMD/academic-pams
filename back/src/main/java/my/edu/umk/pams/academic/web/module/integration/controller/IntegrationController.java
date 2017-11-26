package my.edu.umk.pams.academic.web.module.integration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.dsl.http.Http;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorImpl;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdGroupMember;
import my.edu.umk.pams.academic.identity.model.AdGroupMemberImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdPrincipalImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRole;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRoleImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipalType;
import my.edu.umk.pams.academic.identity.model.AdRoleType;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffImpl;
import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.connector.payload.AccountPayload;
import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.connector.payload.StaffPayload;

/**
 */
@Transactional
@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

	private static final Logger LOG = LoggerFactory.getLogger(IntegrationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CommonService commonService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@Autowired
	private ProfileService profileService;

	// ====================================================================================================
	// COHORT
	// ====================================================================================================
	@RequestMapping(value = "/cohort", method = RequestMethod.POST)
	public ResponseEntity<String> saveCohort() {
		SecurityContext ctx = loginAsSystem();

		AdCohort cohort = new AdCohortImpl();
		cohort.setCode("TODO");
		cohort.setDescription("TODO");
		cohort.setProgram(plannerService.findProgramByCode("TODO"));
		cohort.setCurriculum(plannerService.findCurriculumByCode("TODO"));
		cohort.setSession(plannerService.findCurrentAcademicSession());
		plannerService.saveCohort(cohort);

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}

	// ====================================================================================================
	// STAFF
	// ====================================================================================================
	@RequestMapping(value = "/staff/nonAcademicActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaff(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				// Find Staff
				AdStaff staff = identityService.findStaffByIdentityNo(payload.getStaffId());

				// Find Department Code
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {

					LOG.debug("Has Faculty");
					AdFaculty departmentCode = plannerService.findFacultyByCode(staff.getFaculty().getCode());
					// Find User
					AdUser user = identityService.findUserByUsername(staff.getIdentityNo());
					// Find Group
					AdGroup group = identityService.findGroupByUser(user);

					if (departmentCode.equals(payload.getStaffDepartmentCode())
							&& identityService.isGroupExists(group.getName())) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staff.setStaffType(AdStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());
						identityService.updateStaff(staffUpdate);
						
					} 
/*					else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))
							&& identityService.isGroupExists(group.getName())) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staff.setStaffType(AdStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());
						identityService.updateStaff(staffUpdate);
					}
*/
				} else {

					LOG.debug("NoFaculty");
					AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

					AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
					staffUpdate.setIdentityNo(payload.getStaffId());
					staffUpdate.setName(payload.getStaffName());
					staffUpdate.setActorType(AdActorType.STAFF);
					staff.setStaffType(AdStaffType.NON_ACADEMIC);
					staffUpdate.setPhone(payload.getStaffPhoneNo());
					staffUpdate.setFaculty(faculty);
					staffUpdate.setStaffCategory(payload.getStaffCategory());
					staffUpdate.setEmail(payload.getStaffEmail());
					identityService.updateStaff(staffUpdate);
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
				LOG.debug("Staff Category:{}", payload.getStaffCategory());

				String facultyCode = payload.getStaffDepartmentCode();
				AdFaculty faculty = plannerService.findFacultyByCode(facultyCode);

				AdStaff staff = new AdStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(AdStaffType.NON_ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(AdActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFaculty(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {
					LOG.info("if faculty exists");
					identityService.saveStaffIMSNonAcademicActive(staff);

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STUDENT ACCOUNT
	// ====================================================================================================
	@RequestMapping(value = "/studentAccounts", method = RequestMethod.PUT)
	public ResponseEntity<String> saveStudentAccount(@RequestBody AccountPayload payload) {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receiving Student Account");
		AdStudent student = identityService.findStudentByMatricNo(payload.getMatricNo());
		LOG.debug("Student Name:{}", student.getName());

		student.setBalance(payload.getBalance());
		student.setOutstanding(payload.isOutstanding());
		if (student.getOutstanding() == true) {
			student.setMemo("Outstanding Payments");
		} else {
			student.setMemo("N/A");
		}
		identityService.updateStudent(student);

		LOG.info("Finish Receiving Student Account");
		logoutAsSystem(ctx);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}

	// ====================================================================================================
	// CANDIDATE
	// ====================================================================================================
	@RequestMapping(value = "/candidates", method = RequestMethod.POST)
	public ResponseEntity<String> saveCandidate(@RequestBody CandidatePayload payload) throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start integration candidate controller");

		if (plannerService.isCohortExists(payload.getCohortCode())) {
			LOG.info("cohort already exists");
		} else {
			// Cohort
			AdCohort cohort = new AdCohortImpl();
			cohort.setCode(payload.getCohortCode());
			cohort.setDescription(payload.getCohortCode());
			cohort.setProgram(plannerService.findProgramByCode(payload.getProgramCode()));
			cohort.setSession(plannerService.findCurrentAcademicSession());
			plannerService.saveCohort(cohort);

			LOG.info("cohort not exists");

		}

		// student info
		AdStudent student = new AdStudentImpl();
		student.setMatricNo(payload.getMatricNo());
		student.setName(payload.getName());
		student.setEmail(payload.getEmail());
		student.setFax(payload.getFax());
		student.setPhone(payload.getPhone());
		student.setMobile(payload.getMobile());

		// status, mode and cohort
		student.setStudentStatus(AdStudentStatus.ACTIVE);
		student.setStudyMode(commonService.findStudyModeByCode(payload.getStudyMode().getCode()));
		student.setCohort(plannerService.findCohortByCode(payload.getCohortCode()));
		student.setBalance(BigDecimal.ZERO);
		student.setOutstanding(false);

		identityService.saveStudent(student);

		// Mailing Address
		AdAddress currentAddress = new AdAddressImpl();
		currentAddress.setAddress1(payload.getSecondaryAddress().getAddress1());
		currentAddress.setAddress2(payload.getSecondaryAddress().getAddress2());
		currentAddress.setAddress3(payload.getSecondaryAddress().getAddress3());
		currentAddress.setPostCode(payload.getSecondaryAddress().getPostcode());
		currentAddress.setStateCode(commonService.findStateCodeByCode(payload.getSecondaryAddress().getStateCode()));
		currentAddress
				.setCountryCode(commonService.findCountryCodeByCode(payload.getSecondaryAddress().getCountryCode()));
		currentAddress.setStudent(student);
		currentAddress.setType(AdAddressType.CURRENT);
		profileService.addAddress(student, currentAddress);

		// Billing Address
		AdAddress permenantAddress = new AdAddressImpl();
		permenantAddress.setAddress1(payload.getPrimaryAddress().getAddress1());
		permenantAddress.setAddress2(payload.getPrimaryAddress().getAddress2());
		permenantAddress.setAddress3(payload.getPrimaryAddress().getAddress3());
		permenantAddress.setPostCode(payload.getPrimaryAddress().getPostcode());
		permenantAddress.setStateCode(commonService.findStateCodeByCode(payload.getPrimaryAddress().getStateCode()));
		permenantAddress
				.setCountryCode(commonService.findCountryCodeByCode(payload.getPrimaryAddress().getCountryCode()));
		permenantAddress.setStudent(student);
		permenantAddress.setType(AdAddressType.PERMANENT);
		profileService.addAddress(student, permenantAddress);

		// User
		AdUser user = new AdUserImpl();
		user.setActor(student);
		user.setEmail(payload.getEmail());
		user.setUsername(payload.getEmail());
		user.setPassword(payload.getUserPayload().getPassword());
		user.setRealName(payload.getName());
		identityService.saveUser(user);

		// Principal
		AdPrincipal principal = identityService.findPrincipalByName(payload.getEmail());
		principal.setName(payload.getEmail());
		principal.setPrincipalType(AdPrincipalType.USER);
		principal.setEnabled(true);
		principal.setLocked(true);

		// Principal Role
		AdPrincipalRole role = new AdPrincipalRoleImpl();
		role.setPrincipal(principal);
		role.setRole(AdRoleType.ROLE_USER);
		identityService.addPrincipalRole(principal, role);

		// Group
		AdGroup group = identityService.findGroupByName("GRP_STDN");
		// GroupMember
		AdGroupMember member = new AdGroupMemberImpl();
		member.setGroup(group);
		member.setPrincipal(principal);
		identityService.addGroupMember(group, principal);

		LOG.info("Start Admission");
		AdAcademicSession session = plannerService.findCurrentAcademicSession();
		AdAdmission admission = new AdAdmissionImpl();
		admission.setSession(session);
		admission.setStudent(student);
		admission.setOrdinal(1);

		// Advisor
		if (payload.getFacultyCode().equals("A10")) {
			admission.setAdvisor(null);
		} else {
			AdStaff advisor = identityService.findStaffByIdentityNo(payload.getSupervisorCode());
			LOG.debug("advisor name:{}", advisor.getName());
			admission.setAdvisor(advisor);
		}
		LOG.info("Finish Supervisor");

		admission.setCgpa(BigDecimal.ZERO);
		admission.setCohort(plannerService.findCohortByCode(payload.getCohortCode()));
		admission.setGpa(BigDecimal.ZERO);
		admission.setStanding(AdAcademicStanding.TBD);
		admission.setStatus(AdAdmissionStatus.REGULAR);

		// StudyCenter
		if (payload.getFacultyCode().equals("A10")) {
			LOG.debug("Faculty:{}", payload.getFacultyCode());

			String studyCenterCode = payload.getStudyCenter().getCode();
			admission.setStudyCenter(commonService.findStudyCenterByCode(studyCenterCode));
		} else {
			LOG.debug("Faculty:{}", payload.getFacultyCode());
			LOG.info("StudyCenter NULL");
			admission.setStudyCenter(null);
		}
		LOG.info("Finish StudyCenter");

		termService.saveAdmission(admission);
		LOG.info("Finish Admission");

		LOG.info("Finish integration candidate controller");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
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
}
