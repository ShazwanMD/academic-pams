package my.edu.umk.pams.academic.web.module.profile.controller;

import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.academic.web.module.profile.vo.*;
import my.edu.umk.pams.academic.web.module.term.controller.TermTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.Admission;
import my.edu.umk.pams.academic.web.module.term.vo.AdmissionApplication;
import my.edu.umk.pams.academic.web.module.term.vo.Enrollment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author PAMS
 */

@Transactional
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	private static final Logger LOG = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CommonService commonService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@Autowired
	private TermTransformer termTransformer;

	@Autowired
	private ProfileTransformer profileTransformer;
	
	@Autowired
	private PlannerTransformer plannerTransformer;

	@Autowired
	private SecurityService securityService;

	// ====================================================================================================
	// ADMISSION APPLICATION
	// ====================================================================================================

	/* EDIT ADMISSION APPLICATION */
	@RequestMapping(value = "/students/{identityNo}/admissionApplications/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAdmissionApplication(@PathVariable String identityNo,
			@RequestBody AdmissionApplication vo) {
		dummyLogin();
		LOG.debug("updateAdmissionApplication:{}", vo.getAdvisor());
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdAdmissionApplication application = termService.findAdmissionApplicationById(vo.getId());
		application.setAdvisor(identityService.findStaffByIdentityNo(vo.getAdvisor().getIdentityNo()));
		termService.updateAdmissionApplication(student, application);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	// ====================================================================================================
	// ADDRESS
	// ====================================================================================================

	/* ADD ADDRESS */
	@RequestMapping(value = "/students/{identityNo}/addresses", method = RequestMethod.POST)
	public ResponseEntity<String> addAddress(@PathVariable String identityNo, @RequestBody Address vo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdAddress address = new AdAddressImpl();
		address.setAddress1(vo.getAddress1());
		address.setAddress2(vo.getAddress2());
		address.setAddress3(vo.getAddress3());
		address.setPostCode(vo.getPostcode());
		address.setType(AdAddressType.get(vo.getAddressType().ordinal()));
		address.setStateCode(commonService.findStateCodeById(vo.getStateCode().getId()));
		address.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
		address.setStudent(student);
		profileService.addAddress(student, address);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT ADDRESS */
	@RequestMapping(value = "/students/{identityNo}/addresses/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAddress(@PathVariable String identityNo, @RequestBody Address vo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdAddress address = profileService.findAddressById(vo.getId());
		address.setAddress1(vo.getAddress1());
		address.setAddress2(vo.getAddress2());
		address.setAddress3(vo.getAddress3());
		address.setPostCode(vo.getPostcode());
		address.setStateCode(commonService.findStateCodeById(vo.getStateCode().getId()));
		address.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
		profileService.updateAddress(student, address);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* DELETE ADDRESS */
	@RequestMapping(value = "/students/{identityNo}/addresses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAddress(@PathVariable String identityNo, @PathVariable Long id) {
		dummyLogin();
		LOG.debug("id address masa nak delete:{}", id);
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdAddress address = profileService.findAddressById(id);
		profileService.deleteAddress(student, address);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// CONTACT
	// ====================================================================================================

	/* ADD CONTACT */
	@RequestMapping(value = "/students/{identityNo}/contacts", method = RequestMethod.POST)
	public ResponseEntity<String> addContact(@PathVariable String identityNo, @RequestBody Contact vo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdContact contact = new AdContactImpl();
		contact.setIdentityNo(vo.getIdentityNo());
		contact.setName(vo.getName());
		contact.setPhone(vo.getPhone());
		contact.setType(AdContactType.get(vo.getContactType().ordinal()));
		contact.setStudent(student);
		profileService.addContact(student, contact);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT CONTACT */
	@RequestMapping(value = "/students/{identityNo}/contacts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateContact(@PathVariable String identityNo, @RequestBody Contact vo) {
		dummyLogin();
		LOG.debug("id contact:{}", vo.getId());
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdContact contact = profileService.findContactById(vo.getId());
		contact.setName(vo.getName());
		contact.setIdentityNo(vo.getIdentityNo());
		contact.setPhone(vo.getPhone());
		contact.setType(AdContactType.get(vo.getContactType().ordinal()));
		contact.setStudent(student);
		profileService.updateContact(student, contact);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/contacts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContact(@PathVariable String identityNo, @PathVariable Long id) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdContact contact = profileService.findContactById(id);
		profileService.deleteContact(student, contact);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// GUARANTOR
	// ====================================================================================================

	/* ADD GUARANTOR */
	@RequestMapping(value = "/students/{identityNo}/guarantors", method = RequestMethod.POST)
	public ResponseEntity<String> addGuarantor(@PathVariable String identityNo, @RequestBody Guarantor vo) {
		dummyLogin();

		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdGuarantor guarantor = new AdGuarantorImpl();
		guarantor.setIdentityNo(vo.getIdentityNo());
		guarantor.setName(vo.getName());
		guarantor.setPhone(vo.getPhone());
		guarantor.setType(AdGuarantorType.get(vo.getGuarantorType().ordinal()));
		guarantor.setStudent(student);
		profileService.addGuarantor(student, guarantor);
		LOG.debug("Guarantor:{}", guarantor.getPhone());
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT GUARANTOR */
	@RequestMapping(value = "/students/{identityNo}/guarantors/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateGuarantor(@PathVariable String identityNo, @RequestBody Guarantor vo) {
		dummyLogin();
		LOG.debug("id guarantor:{}", vo.getId());
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdGuarantor guarantor = profileService.findGuarantorById(vo.getId());
		guarantor.setName(vo.getName());
		guarantor.setIdentityNo(vo.getIdentityNo());
		guarantor.setPhone(vo.getPhone());
		guarantor.setType(AdGuarantorType.get(vo.getGuarantorType().ordinal()));
		guarantor.setStudent(student);
		profileService.updateGuarantor(student, guarantor);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* DELETE GUARANTOR */
	@RequestMapping(value = "/students/{identityNo}/guarantors/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteGuarantor(@PathVariable String identityNo, @PathVariable Long id) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdGuarantor guarantor = profileService.findGuarantorById(id);
		profileService.deleteGuarantor(student, guarantor);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// GUARDIAN
	// ====================================================================================================

	/* ADD GUARDIAN */
	@RequestMapping(value = "/students/{identityNo}/guardians", method = RequestMethod.POST)
	public ResponseEntity<String> addGuardian(@PathVariable String identityNo, @RequestBody Guardian vo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdGuardian guardian = new AdGuardianImpl();
		guardian.setIdentityNo(vo.getIdentityNo());
		guardian.setName(vo.getName());
		guardian.setPhone(vo.getPhone());
		guardian.setType(AdGuardianType.get(vo.getGuardianType().ordinal()));
		guardian.setStudent(student);
		profileService.addGuardian(student, guardian);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT GUARDIAN */
	@RequestMapping(value = "/students/{identityNo}/guardians/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateGuardian(@PathVariable String identityNo, @RequestBody Guardian vo) {
		dummyLogin();
		LOG.debug("id guardian:{}", vo.getId());
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdGuardian guardian = profileService.findGuardianById(vo.getId());
		guardian.setName(vo.getName());
		guardian.setPhone(vo.getPhone());
		guardian.setIdentityNo(vo.getIdentityNo());
		guardian.setType(AdGuardianType.get(vo.getGuardianType().ordinal()));
		guardian.setStudent(student);
		profileService.updateGuardian(student, guardian);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* DELETE GUARDIAN */
	@RequestMapping(value = "/students/{identityNo}/guardians/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteGuardian(@PathVariable String identityNo, @PathVariable Long id) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdGuardian guardian = profileService.findGuardianById(id);
		profileService.deleteGuardian(student, guardian);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	// ===================================================================================================================================
	// NEW DASHBOARD
	// ===================================================================================================================================

	@RequestMapping(value = "/studentLogins", method = RequestMethod.GET)
	public ResponseEntity<Student> findStudentByUser() {
		// Get Current User
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		List<AdAddress> addresss = profileService.findAddresses(student);
		profileTransformer.toAddressVos(addresss);
		return new ResponseEntity<Student>(profileTransformer.toStudentVo(student), HttpStatus.OK);
	}

	@RequestMapping(value = "/studentLogins/{matricNo}", method = RequestMethod.GET)
	public ResponseEntity<Student> findStudentsByMatricNo(@PathVariable String matricNo)
			throws UnsupportedEncodingException {

		// Get Current User
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");

		return new ResponseEntity<Student>(
				profileTransformer.toStudentVo(profileService.findStudentByMatricNo(matricNo)), HttpStatus.OK);
	}

	@RequestMapping(value = "/studentLogins/addresses", method = RequestMethod.GET)
	public ResponseEntity<List<Address>> findAddressessByStudent() {
		// Get Current User
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();
		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		LOG.debug("address", profileService.findAddresses(student1));
		return new ResponseEntity<List<Address>>(
				profileTransformer.toAddressVos(profileService.findAddresses(student1)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentLogins/academicSessions", method = RequestMethod.GET)
	public ResponseEntity<List<AcademicSession>> findAcademicSessionsByStudent() {
		// Get Current User
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		
		String identityNo = student.getIdentityNo();
		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		
		List<AdAcademicSession> academicSessions = plannerService.findAcademicSessions(0, Integer.MAX_VALUE);
		LOG.debug("academicSession:{}", academicSessions);
		
		return new ResponseEntity<List<AcademicSession>>(
				plannerTransformer.toAcademicSessionVos(academicSessions),HttpStatus.OK);
	}

	// ====================================================================================================
	// STUDENT PROFILE CONTACT
	// ====================================================================================================

	@RequestMapping(value = "/students/contacts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentContact(@PathVariable Long id) {

		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		LOG.debug("Sini:{}", student1);
		AdContact contact = profileService.findContactById(id);
		profileService.deleteContact(student1, contact);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/contacts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateContact(@RequestBody Contact vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		LOG.debug("Sini:{}", student1);
		LOG.debug("id contact:{}", vo.getId());

		AdContact contact = profileService.findContactById(vo.getId());
		contact.setName(vo.getName());
		contact.setIdentityNo(vo.getIdentityNo());
		contact.setPhone(vo.getPhone());
		contact.setType(AdContactType.get(vo.getContactType().ordinal()));
		contact.setStudent(student1);
		profileService.updateContact(student1, contact);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/contacts", method = RequestMethod.POST)
	public ResponseEntity<String> addContact(@RequestBody Contact vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdContact contact = new AdContactImpl();
		contact.setIdentityNo(vo.getIdentityNo());
		contact.setName(vo.getName());
		contact.setPhone(vo.getPhone());
		contact.setType(AdContactType.get(vo.getContactType().ordinal()));
		contact.setStudent(student1);
		profileService.addContact(student1, contact);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// GUARDIAN
	// ====================================================================================================

	/* ADD GUARDIAN */
	@RequestMapping(value = "/students/guardians", method = RequestMethod.POST)
	public ResponseEntity<String> addStudentGuardian(@RequestBody Guardian vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);

		AdGuardian guardian = new AdGuardianImpl();
		guardian.setIdentityNo(vo.getIdentityNo());
		guardian.setName(vo.getName());
		guardian.setPhone(vo.getPhone());
		guardian.setType(AdGuardianType.get(vo.getGuardianType().ordinal()));
		guardian.setStudent(student1);
		profileService.addGuardian(student1, guardian);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT GUARDIAN */
	@RequestMapping(value = "/students/guardians/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudentGuardian(@RequestBody Guardian vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdGuardian guardian = profileService.findGuardianById(vo.getId());
		guardian.setName(vo.getName());
		guardian.setPhone(vo.getPhone());
		guardian.setIdentityNo(vo.getIdentityNo());
		guardian.setType(AdGuardianType.get(vo.getGuardianType().ordinal()));
		guardian.setStudent(student1);
		profileService.updateGuardian(student1, guardian);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* DELETE GUARDIAN */
	@RequestMapping(value = "/students/guardians/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentGuardian(@PathVariable Long id) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdGuardian guardian = profileService.findGuardianById(id);
		profileService.deleteGuardian(student1, guardian);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// GUARANTOR
	// ====================================================================================================

	/* ADD GUARANTOR */
	@RequestMapping(value = "/students/guarantors", method = RequestMethod.POST)
	public ResponseEntity<String> addStudentGuarantor(@RequestBody Guarantor vo) {
		// dummyLogin();

		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdGuarantor guarantor = new AdGuarantorImpl();
		guarantor.setIdentityNo(vo.getIdentityNo());
		guarantor.setName(vo.getName());
		guarantor.setPhone(vo.getPhone());
		guarantor.setType(AdGuarantorType.get(vo.getGuarantorType().ordinal()));
		guarantor.setStudent(student1);
		profileService.addGuarantor(student1, guarantor);
		LOG.debug("Guarantor:{}", guarantor.getPhone());
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT GUARANTOR */
	@RequestMapping(value = "/students/guarantors/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudentGuarantor(@RequestBody Guarantor vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdGuarantor guarantor = profileService.findGuarantorById(vo.getId());
		guarantor.setName(vo.getName());
		guarantor.setIdentityNo(vo.getIdentityNo());
		guarantor.setPhone(vo.getPhone());
		guarantor.setType(AdGuarantorType.get(vo.getGuarantorType().ordinal()));
		guarantor.setStudent(student1);
		profileService.updateGuarantor(student1, guarantor);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* DELETE GUARANTOR */
	@RequestMapping(value = "/students/guarantors/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentGuarantor(@PathVariable Long id) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdGuarantor guarantor = profileService.findGuarantorById(id);
		profileService.deleteGuarantor(student1, guarantor);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STUDENT - ADDRESS
	// ====================================================================================================

	/* ADD ADDRESS */
	@RequestMapping(value = "/students/addresses", method = RequestMethod.POST)
	public ResponseEntity<String> addStudentAddress(@RequestBody Address vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdAddress address = new AdAddressImpl();
		address.setAddress1(vo.getAddress1());
		address.setAddress2(vo.getAddress2());
		address.setAddress3(vo.getAddress3());
		address.setPostCode(vo.getPostcode());
		address.setType(AdAddressType.get(vo.getAddressType().ordinal()));
		address.setStateCode(commonService.findStateCodeById(vo.getStateCode().getId()));
		address.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
		address.setStudent(student1);
		profileService.addAddress(student1, address);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* EDIT ADDRESS */
	@RequestMapping(value = "/students/addresses/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudentAddress(@RequestBody Address vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdAddress address = profileService.findAddressById(vo.getId());
		address.setAddress1(vo.getAddress1());
		address.setAddress2(vo.getAddress2());
		address.setAddress3(vo.getAddress3());
		address.setPostCode(vo.getPostcode());
		address.setStateCode(commonService.findStateCodeById(vo.getStateCode().getId()));
		address.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
		profileService.updateAddress(student1, address);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/* DELETE ADDRESS */
	@RequestMapping(value = "/students/addresses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentAddress(@PathVariable Long id) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		AdAddress address = profileService.findAddressById(id);
		profileService.deleteAddress(student1, address);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudentDetail(@RequestBody Student vo) {
		// dummyLogin();
		AdUser user = securityService.getCurrentUser();

		AdStudent student = null;

		if (user.getActor() instanceof AdStudent)
			student = (AdStudent) user.getActor();
		if (null == student)
			throw new IllegalArgumentException("Student does not exists");
		String identityNo = student.getIdentityNo();

		AdStudent student1 = profileService.findStudentByMatricNo(identityNo);
		// AdStudent studentById = profileService.findStudentById(vo.getId());
		student1.setName(vo.getName());
		student1.setPhone(vo.getPhone());
		student1.setEmail(vo.getEmail());
		student1.setMobile(vo.getMobile());
		student1.setFax(vo.getFax());
		student1.setStudyMode(commonService.findStudyModeById(vo.getStudyMode().getId()));
		student1.setCohort(plannerService.findCohortById(vo.getCohort().getId()));
		student1.setStudentStatus(AdStudentStatus.get(vo.getStudentStatus().ordinal()));
		student1.setMemo(vo.getMemo());
		profileService.updateStudent(student1);
		LOG.debug("StudyMode:{}", student1.getStudyMode().getDescription());
		LOG.debug("Cohort Student Baru:{}", student1.getCohort().getCode());
		LOG.debug("StudentStatus:{}", student1.getStudentStatus().name());
		return new ResponseEntity<String>("Success", HttpStatus.OK);

	}

	// ====================================================================================================
	// PROFILE
	// ====================================================================================================

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> findStudents() {
		List<AdStudent> students = profileService.findStudents(0, Integer.MAX_VALUE);
		return new ResponseEntity<List<Student>>(profileTransformer.toStudentVos(students), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{matricNo}", method = RequestMethod.GET)
	public ResponseEntity<Student> findStudentByMatricNo(@PathVariable String matricNo)
			throws UnsupportedEncodingException {
		return new ResponseEntity<Student>(
				profileTransformer.toStudentVo(profileService.findStudentByMatricNo(matricNo)), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{matricNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(@PathVariable String matricNo, @RequestBody Student vo) {
		dummyLogin();
		AdStudent student = profileService.findStudentById(vo.getId());
		student.setName(vo.getName());
		student.setPhone(vo.getPhone());
		student.setEmail(vo.getEmail());
		student.setMobile(vo.getMobile());
		student.setFax(vo.getFax());
		student.setStudyMode(commonService.findStudyModeById(vo.getStudyMode().getId()));
		student.setCohort(plannerService.findCohortById(vo.getCohort().getId()));
		student.setStudentStatus(AdStudentStatus.get(vo.getStudentStatus().ordinal()));
		student.setMemo(vo.getMemo());
		profileService.updateStudent(student);
		LOG.debug("StudyMode:{}", student.getStudyMode().getDescription());
		LOG.debug("Cohort Student Baru:{}", student.getCohort().getCode());
		LOG.debug("StudentStatus:{}", student.getStudentStatus().name());
		return new ResponseEntity<String>("Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/students/{identityNo}/guardians", method = RequestMethod.GET)
	public ResponseEntity<List<Guardian>> findGuardiansByStudent(@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		return new ResponseEntity<List<Guardian>>(
				profileTransformer.toGuardianVos(profileService.findGuardians(student)), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/guarantors", method = RequestMethod.GET)
	public ResponseEntity<List<Guarantor>> findGuarantorsByStudent(@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		return new ResponseEntity<List<Guarantor>>(
				profileTransformer.toGuarantorVos(profileService.findGuarantors(student)), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/enrollments", method = RequestMethod.GET)
	public ResponseEntity<List<Enrollment>> findEnrollmentsByStudent(@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		// AdAcademicSession academicSession =
		// plannerService.findCurrentAcademicSession();
		List<AdEnrollment> enrollments = termService.findEnrollments(student);
		List<Enrollment> vos = termTransformer.toEnrollmentVos(enrollments);
		return new ResponseEntity<List<Enrollment>>(vos, HttpStatus.OK);
	}

	// find admissions by student
	@RequestMapping(value = "/students/{identityNo}/admissions", method = RequestMethod.GET)
	public ResponseEntity<List<Admission>> findAdmissionsByStudent(@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		// AdAcademicSession academicSession =
		// plannerService.findCurrentAcademicSession();
		List<AdAdmission> admissions = termService.findAdmissions(student);
		List<Admission> vos = termTransformer.toAdmissionVos(admissions);
		return new ResponseEntity<List<Admission>>(vos, HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/addresses", method = RequestMethod.GET)
	public ResponseEntity<List<Address>> findAddressesByStudent(@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		return new ResponseEntity<List<Address>>(profileTransformer.toAddressVos(profileService.findAddresses(student)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/admissionApplications", method = RequestMethod.GET)
	public ResponseEntity<List<AdmissionApplication>> findAmissionApplicationsByStudent(
			@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		return new ResponseEntity<List<AdmissionApplication>>(
				termTransformer.toAdmissionApplicationVos(termService.findAdmissionApplications(student)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/contacts", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> findContactsByStudent(@PathVariable String identityNo) {
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		return new ResponseEntity<List<Contact>>(profileTransformer.toContactVos(profileService.findContacts(student)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/activate", method = RequestMethod.POST)
	public ResponseEntity<AdStudentStatus> activateStudent(@PathVariable String identityNo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		student.setStudentStatus(AdStudentStatus.ACTIVE);
		profileService.activateStudent(student);
		return new ResponseEntity<AdStudentStatus>(student.getStudentStatus(), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/deactivate", method = RequestMethod.POST)
	public ResponseEntity<AdStudentStatus> deactivateStudent(@PathVariable String identityNo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		student.setStudentStatus(AdStudentStatus.INACTIVE);
		profileService.deactivateStudent(student);
		return new ResponseEntity<AdStudentStatus>(student.getStudentStatus(), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/barStudent", method = RequestMethod.POST)
	public ResponseEntity<AdStudentStatus> barStudent(@PathVariable String identityNo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		student.setStudentStatus(AdStudentStatus.BARRED);
		profileService.barStudent(student);
		return new ResponseEntity<AdStudentStatus>(student.getStudentStatus(), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/switchStudyMode", method = RequestMethod.POST)
	public ResponseEntity<String> switchStudyMode(@PathVariable String identityNo, @RequestBody SwitchStudyMode vo) {
		dummyLogin();
		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getAcademicSession().getId());
		AdStudyMode from = commonService.findStudyModeById(vo.getFrom().getId());
		AdStudyMode to = commonService.findStudyModeById(vo.getTo().getId());

		String newMatricNo = profileService.switchStudyMode(student, academicSession, from, to);
		return new ResponseEntity<String>(newMatricNo, HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{identityNo}/transferCohort", method = RequestMethod.POST)
	public ResponseEntity<String> transferCohort(@PathVariable String identityNo, @RequestBody TransferCohort vo) {
		dummyLogin();

		AdStudent student = profileService.findStudentByMatricNo(identityNo);
		AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getAcademicSession().getId());
		AdCohort from = plannerService.findCohortById(vo.getFrom().getId());
		AdCohort to = plannerService.findCohortById(vo.getTo().getId());

		String newMatricNo = profileService.transferCohort(student, academicSession, from, to);
		return new ResponseEntity<String>(newMatricNo, HttpStatus.OK);

	}

	// ====================================================================================================
	// PRIVATE METHODS
	// ====================================================================================================

	private void dummyLogin() {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
		Authentication authed = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authed);
	}
}
