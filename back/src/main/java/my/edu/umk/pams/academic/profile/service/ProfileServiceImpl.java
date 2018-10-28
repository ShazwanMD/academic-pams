package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.graduation.dao.AdGraduationApplicationDao;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.identity.dao.AdStudentDao;
import my.edu.umk.pams.academic.identity.event.GuardianAddedEvent;
import my.edu.umk.pams.academic.identity.event.MinAmountAddedEvent;
import my.edu.umk.pams.academic.identity.event.StudentActivatedEvent;
import my.edu.umk.pams.academic.identity.event.StudentBarredEvent;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.planner.dao.AdAcademicSessionDao;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.connector.payload.GuardianPayload;
import my.edu.umk.pams.connector.payload.GuardianTypePayload;
import my.edu.umk.pams.connector.payload.MinAmountPayload;
import my.edu.umk.pams.connector.payload.StudentPayload;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PAMS
 */
@Transactional
@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

	private static final Logger LOG = LoggerFactory.getLogger(ProfileServiceImpl.class);

	private String academicSesion = "201720181";

	@Autowired
	private AdStudentDao studentDao;

	@Autowired
	private AdGraduationApplicationDao graduationApplicationDao;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AdAcademicSessionDao academicSessionDao;

	// ====================================================================================================
	// STUDENT
	// ====================================================================================================

	@Override
	public AdStudent findStudentById(Long id) {
		return studentDao.findById(id);
	}

	@Override
	public AdGuarantor findGuarantorById(Long id) {
		return studentDao.findGuarantorById(id);
	}

	@Override
	public AdAddress findAddressById(Long id) {
		return studentDao.findAddressById(id);
	}

	@Override
	public AdGuardian findGuardianById(Long id) {
		return studentDao.findGuardianById(id);
	}

	@Override
	public AdContact findContactById(Long id) {
		return studentDao.findContactById(id);
	}

	@Override
	public AdStudent findStudentByMatricNo(String matricNo) {
		return identityService.findStudentByMatricNo(matricNo);
	}

//	@Override
//	public List<AdStudent> findStudents(Integer offset, Integer limit) {
//		return identityService.findStudents(offset, limit);
//	}
	
	@Override
	public List<AdStudent> findStudents() {
		return identityService.findStudents();
	}

	// findGraduatedStudents
	@Override
	public List<AdStudent> findGraduatedStudents(Integer offset, Integer limit) {
		return identityService.findGraduatedStudents(offset, limit);
	}

	@Override
	public List<AdStudent> findStudents(String filter, Integer offset, Integer limit) {
		return identityService.findStudents();
	//	return identityService.findStudents(offset, limit);
	}

	@Override
	public List<AdAddress> findAddresses(AdStudent student) {
		return studentDao.findAddresses(student);
	}

	@Override
	public List<AdGuarantor> findGuarantors(AdStudent student) {
		return studentDao.findGuarantors(student);
	}

	@Override
	public List<AdGuardian> findGuardians(AdStudent student) {
		return studentDao.findGuardians(student);
	}

	@Override
	public List<AdContact> findContacts(AdStudent student) {
		return studentDao.findContacts(student);
	}

	@Override
	public List<AdStudent> findStudentsByFaculty(AdFaculty faculty) {
		return studentDao.findStudentsByFaculty(faculty);
	}
	
	@Override
	public List<AdStudent> findStudentsByGraduateCenter(AdGraduateCenter graduateCenter) {
		return studentDao.findStudentsByGraduateCenter(graduateCenter);
	}

	@Override
	public void updateStudent(AdStudent student) {
		studentDao.update(student, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addMinAmount(AdStudent student) {
		studentDao.update(student, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

		LOG.info("Start Broadcast MinAmount Payload");
		
		StudentPayload studentPayload = new StudentPayload();
		studentPayload.setMatricNo(student.getMatricNo());
		studentPayload.setName(student.getName());
		
		MinAmountPayload payload = new MinAmountPayload();
		payload.setMinimalAmount(student.getMinimalAmount());
		payload.setStudentPayload(studentPayload);
		
		applicationContext.publishEvent(new MinAmountAddedEvent(payload));
		LOG.debug("Payload:{}",payload.getMinimalAmount());
		LOG.info("Finish Broadcast MinAmount Payload");
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* ADDRESS */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public void addAddress(AdStudent student, AdAddress address) {
		studentDao.addAddress(student, address, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateAddress(AdStudent student, AdAddress address) {
		studentDao.updateAddress(student, address, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteAddress(AdStudent student, AdAddress address) {
		studentDao.deleteAddress(student, address, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* GUARANTOR */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public void addGuarantor(AdStudent student, AdGuarantor guarantor) {
		studentDao.addGuarantor(student, guarantor, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateGuarantor(AdStudent student, AdGuarantor guarantor) {
		studentDao.updateGuarantor(student, guarantor, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteGuarantor(AdStudent student, AdGuarantor guarantor) {
		studentDao.deleteGuarantor(student, guarantor, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* GUARDIAN */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public void addGuardian(AdStudent student, AdGuardian guardian) {
		studentDao.addGuardian(student, guardian, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

		LOG.info("Start Broadcast Guardian Payload");

		StudentPayload studentId = new StudentPayload();
		studentId.setMatricNo(student.getIdentityNo());
		studentId.setName(student.getName());

		GuardianPayload payload = new GuardianPayload();
		payload.setIdentityNo(guardian.getIdentityNo());
		payload.setName(guardian.getName());
		payload.setPhone(guardian.getPhone());
		payload.setStudentPayload(studentId);
		payload.setType(GuardianTypePayload.get(guardian.getType().ordinal()));

		applicationContext.publishEvent(new GuardianAddedEvent(payload));

		LOG.info("Finish Broadcast Guardian Payload");
	}

	@Override
	public void updateGuardian(AdStudent student, AdGuardian guardian) {
		studentDao.updateGuardian(student, guardian, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteGuardian(AdStudent student, AdGuardian guardian) {
		studentDao.deleteGuardian(student, guardian, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* CONTACT */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public void addContact(AdStudent student, AdContact contact) {
		studentDao.addContact(student, contact, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateContact(AdStudent student, AdContact contact) {
		studentDao.updateContact(student, contact, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteContact(AdStudent student, AdContact contact) {
		studentDao.deleteContact(student, contact, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* BUSSINESS - ACTIVATE/BAR/ PROCESS */
	/*
	 * =========================================================================
	 * ===================
	 */

	@Override
	public void activateStudent(AdStudent student) {
		student.setStudentStatus(AdStudentStatus.ACTIVE);
		updateStudent(student);

		// trigger event
		applicationContext.publishEvent(new StudentActivatedEvent(student));
	}

	@Override
	public void deactivateStudent(AdStudent student) {
		student.setStudentStatus(AdStudentStatus.INACTIVE);
		updateStudent(student);

		// trigger event
		applicationContext.publishEvent(new StudentActivatedEvent(student));
	}

	@Override
	public void barStudent(AdStudent student) {
		student.setStudentStatus(AdStudentStatus.BARRED);
		updateStudent(student);

		// trigger event
		applicationContext.publishEvent(new StudentBarredEvent(student));
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* BUSSINESS - TRANSFER FACULTY */
	/*
	 * =========================================================================
	 * ===================
	 */

	@Override
	public String transferFaculty(AdStudent student, AdAcademicSession academicSession, AdFaculty fromFaculty,
			AdFaculty toFaculty) {
		AdProgramLevel programLevel = student.getCohort().getProgram().getLevel();
		AdStudyMode studyMode = student.getStudyMode();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("facultyCode", toFaculty);
		map.put("academicSession", academicSession);
		map.put("programLevel", programLevel);
		map.put("studyMode", studyMode);

		String generatedMatricNo = systemService.generateFormattedReferenceNo(AcademicConstants.STUDENT_MATRIC_NO, map);
		student.setMatricNo(generatedMatricNo);
		updateStudent(student);
		LOG.debug("Student New MatricNo:{}", student.getMatricNo());

		return generatedMatricNo;
	}

	@Override
	public String transferCohort(AdStudent student, AdAcademicSession academicSession, AdCohort fromCohort,
			AdCohort toCohort) {
		AdProgramLevel programLevel = student.getCohort().getProgram().getLevel();
		AdFaculty faculty = student.getCohort().getProgram().getFaculty();
		AdStudyMode studyMode = student.getStudyMode();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("facultyCode", faculty);
		map.put("academicSession", academicSession);
		map.put("programLevel", programLevel);
		map.put("studyMode", studyMode);

		String generatedMatricNo = systemService.generateFormattedReferenceNo(AcademicConstants.STUDENT_MATRIC_NO, map);
		student.setMatricNo(generatedMatricNo);
		student.setCohort(toCohort);
		updateStudent(student);
		LOG.debug("Student New MatricNo:{}", student.getMatricNo());
		LOG.debug("Student New Cohort:{}", student.getCohort().getCode());

		return generatedMatricNo;
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* BUSSINESS - SWITCH STUDYMODE */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public String switchStudyMode(AdStudent student, AdAcademicSession academicSession, AdStudyMode fromMode,
			AdStudyMode toMode) {
		AdFaculty facultyCode = student.getCohort().getProgram().getFaculty();
		AdProgramLevel programLevel = student.getCohort().getProgram().getLevel();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("facultyCode", facultyCode);
		map.put("academicSession", academicSession);
		map.put("programLevel", programLevel);
		map.put("studyMode", toMode);

		String generatedMatricNo = systemService.generateFormattedReferenceNo(AcademicConstants.STUDENT_MATRIC_NO, map);
		student.setMatricNo(generatedMatricNo);
		student.setStudyMode(toMode);
		updateStudent(student);
		LOG.debug("Student New MatricNo :{}", student.getMatricNo());
		return generatedMatricNo;
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplications(AdStudent student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdAdmission findAdmissionByAcademicSessionAndStudent(AdAcademicSession academicSession, AdStudent student) {

		return studentDao.findAdmissionByAcademicSessionAndStudent(academicSession, student);
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* GRADUATION APPLICATION */
	/*
	 * =========================================================================
	 * ===================
	 */

	@Override
	public List<AdGraduationApplication> findGraduationApplications(AdStudent student) {
		return graduationApplicationDao.findGraduationApplications(student);
	}

}
