package my.edu.umk.pams.academic.term.service;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.dao.AdAdmissionApplicationDao;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.dao.*;
import my.edu.umk.pams.academic.term.event.*;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.workflow.service.WorkflowConstants;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.Validate;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static my.edu.umk.pams.academic.AcademicConstants.ENROLLMENT_APPLICATION_ID;
import static my.edu.umk.pams.academic.AcademicConstants.ENROLLMENT_APPLICATION_REFERENCE_NO;
import static my.edu.umk.pams.academic.core.AdFlowState.DRAFTED;

/**
 * @author PAMS
 */
@Service("termService")
public class TermServiceImpl implements TermService {

	private static final Logger LOG = LoggerFactory.getLogger(TermServiceImpl.class);

	@Autowired
	private AdOfferingDao offeringDao;

	@Autowired
	private AdSectionDao sectionDao;

	@Autowired
	private AdAdmissionApplicationDao admissionApplicationDao;
	
		@Autowired
	private AdEnrollmentApplicationDao enrollmentApplicationDao;

	@Autowired
	private AdEnrollmentDao enrollmentDao;

	@Autowired
	private AdAppointmentDao appointmentDao;

	@Autowired
	private AdAssessmentDao assessmentDao;

	@Autowired
	private AdGradebookDao gradebookDao;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ApplicationContext applicationContext;

	// ====================================================================================================
	// ADMISSION APPLICATION
	// ====================================================================================================

	@Override
	public void saveAdmission(AdAdmissionApplication admissionApplication) {

		admissionApplicationDao.save(admissionApplication, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public AdAdmissionApplication findAdmissionApplicationByProgramAndStudent(AdProgram program, AdStudent student) {
		return admissionApplicationDao.findByProgramAndStudent(program, student);
	}

	// ====================================================================================================
	// OFFERING
	// ====================================================================================================

	@Override
	public AdOffering findOfferingById(Long id) {
		return offeringDao.findById(id);
	}

	@Override
	public AdOffering findOfferingByCanonicalCode(String canonicalCode) {
		return offeringDao.findByCanonicalCode(canonicalCode);
	}

	@Override
	public AdOffering findOfferingByProgramAndCourse(AdProgram program, AdCourse course) {
		return offeringDao.findByProgramAndCourse(program, course);
	}

	@Override
	public AdAcademicSession findLastOfferedOffering(AdAcademicSession current, AdCourse course) {
		return null;
	}

	@Override
	public List<AdOffering> findOfferings(Integer offset, Integer limit) {
		return offeringDao.find(offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, Integer offset, Integer limit) {
		return offeringDao.find(filter, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(AdProgram program) {
		return offeringDao.find(program);
	}

	@Override
	public List<AdOffering> findOfferings(AdProgram program, Integer offset, Integer limit) {
		return offeringDao.find(program, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		return offeringDao.find(filter, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, AdProgram program,
			Integer offset, Integer limit) {
		return offeringDao.find(filter, academicSession, program, offset, limit);
	}

	@Override
	public List<AdOffering> findRunningOfferings(AdAcademicSession session) {
		return null; // TODO;
	}

	@Override
	public Integer countOffering(String filter) {
		return offeringDao.count(filter);
	}

	@Override
	public Integer countOffering(AdProgram program) {
		return offeringDao.count(program);
	}

	@Override
	public Integer countOffering(AdCourse course) {
		return offeringDao.count(course);
	}

	@Override
	public Integer countOffering(boolean authorized, String filter) {
		return offeringDao.count(filter); // todo(uda): auth
	}

	@Override
	public Integer countOffering(boolean authorized, String filter, AdProgram program) {
		return offeringDao.count(filter, program); // todo(uda): auth
	}

	@Override
	public Integer countOfferingWithSection(boolean authorized, String filter) {
		return offeringDao.countWithSection(filter); // todo(uda): auth
	}

	@Override
	public Integer countOfferingWithSection(boolean authorized, String filter, AdAcademicSession academicSession) {
		return offeringDao.countWithSection(filter, academicSession); // todo(uda):
																		// auth
	}

	@Override
	public boolean isOfferingExists(AdProgram program, AdCourse course) {
		return offeringDao.isExists(program, course);
	}

	@Override
	public void saveOffering(AdOffering offering) {
		offeringDao.save(offering, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	// ====================================================================================================
	// SECTION
	// ====================================================================================================

	@Override
	public AdSection findSectionById(Long id) {
		return sectionDao.findById(id);
	}

	@Override
	public AdSection findSectionByCanonicalCode(String canonicalCode) {
		return sectionDao.findByCanonicalCode(canonicalCode);
	}

	@Override
	public List<AdSection> findSections(Integer offset, Integer limit) {
		return sectionDao.find(offset, limit);
	}

	// todo: decorate
	@Override
	public List<AdSection> findSections(String filter, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		return sectionDao.find(filter, academicSession, offset, limit);
	}

	@Override
	public List<AdSection> findSections(AdOffering offering) {
		return sectionDao.find(offering);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession) {
		return sectionDao.find(academicSession);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, Integer offset, Integer limit) {
		return sectionDao.find(academicSession, offset, limit);
	}

	// todo(uda): decorate
	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.find(academicSession, offering);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering, Integer offset,
			Integer limit) {
		return sectionDao.find(academicSession, offering, offset, limit);
	}

	@Override
	public List<AdSection> findSections(String filter, AdAcademicSession academicSession, AdAdmission admission,
			Integer offset, Integer limit) {
		return sectionDao.find(filter, academicSession, admission, offset, limit);
	}

	@Override
	public Integer countSection() {
		return sectionDao.count();
	}

	@Override
	public Integer countSection(String filter, AdAcademicSession academicSession) {
		return sectionDao.count(filter, academicSession);
	}

	@Override
	public Integer countSection(AdOffering offering) {
		return sectionDao.count(offering);
	}

	@Override
	public Integer countSection(AdAcademicSession academicSession) {
		return sectionDao.count(academicSession);
	}

	@Override
	public Integer countSection(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.count(academicSession, offering);
	}

	@Override
	public Integer countSection(String filter, AdAcademicSession academicSession, AdAdmission admission) {
		return sectionDao.count(filter, academicSession, admission);
	}

	@Override
	public Integer countAvailableStaff(AdOffering offering) {
		return sectionDao.countAvailableStaff(offering);
	}

	@Override
	public Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.countAvailableStaff(academicSession, offering);
	}

	@Override
	public boolean hasSection(AdAcademicSession academicSession) {
		return sectionDao.hasSection(academicSession);
	}

	@Override
	public boolean hasSection(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.hasSection(academicSession, offering);
	}

	@Override
	public boolean isSectionExists(String canonicalCode) {
		return sectionDao.isExists(canonicalCode);
	}

	@Override
	public void openSection(AdSection section) {
		// todo(uda): exception = Section already exists

		sectionDao.save(section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(section);

		SectionOpenedEvent event = new SectionOpenedEvent();
		applicationContext.publishEvent(event);
	}

	@Override
	public void closeSection(AdSection section) {
		// todo(uda): exception- Section has enrollment. Please remove
		// enrollment first;
		List<AdEnrollment> enrollments = findEnrollments(section);
		// todo(uda): remove gradebook
		// todo(uda): remove enrollment
		// todo(uda): remove appointment
		// todo(uda): remove auth

		SectionClosedEvent event = new SectionClosedEvent();
		applicationContext.publishEvent(event);
	}

	@Override
	public void saveSection(AdSection section) {
		sectionDao.save(section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateSection(AdSection section) {
		sectionDao.update(section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeSection(AdSection section) {
		sectionDao.remove(section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// ENROLLMENT APPLICATION
	// ====================================================================================================

	@Override
	public AdEnrollmentApplication findEnrollmentApplicationByTaskId(String taskId) {
		Task task = workflowService.findTask(taskId);
		Map<String, Object> map = workflowService.getVariables(task.getExecutionId());
		return enrollmentApplicationDao.findById((Long) map.get(ENROLLMENT_APPLICATION_ID));
	}

	@Override
	public Task findEnrollmentApplicationTaskByTaskId(String taskId) {
		return workflowService.findTask(taskId);
	}

	@Override
	public List<Task> findAssignedEnrollmentApplicationTasks(Integer offset, Integer limit) {
		return workflowService.findAssignedTasks(AdEnrollmentApplication.class.getName(), offset, limit);
	}

	@Override
	public List<Task> findPooledEnrollmentApplicationTasks(Integer offset, Integer limit) {
		return workflowService.findPooledTasks(AdEnrollmentApplication.class.getName(), offset, limit);
	}

	@Override
	public Integer countAssignedEnrollmentApplicationTasks() {
		return workflowService.countAssignedTask(AdEnrollmentApplication.class.getName());
	}

	@Override
	public Integer countPooledEnrollmentApplicationTasks() {
		return workflowService.countPooledTask(AdEnrollmentApplication.class.getName());
	}

	@Override
	public void startEnrollmentApplicationTask(AdEnrollmentApplication application) {
		// todo(uda): param
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(ENROLLMENT_APPLICATION_REFERENCE_NO, param);
		application.setReferenceNo(refNo);

		enrollmentApplicationDao.save(application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(application);

		// trigger workflow
		workflowService.processWorkflow(application, prepareVariables(application));
	}

	@Override
	public void updateEnrollmentApplication(AdEnrollmentApplication application) {
		enrollmentApplicationDao.update(application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void cancelEnrollmentApplication(AdEnrollmentApplication application) {
		Validate.notNull(application, "EnrollmentApplication cannot be null");
		Validate.isTrue(DRAFTED.equals(application.getFlowdata().getState()),
				"EnrollmentApplication can only be cancelled in DRAFTED state");
		enrollmentApplicationDao.update(application, securityService.getCurrentUser());
	}

	@Override
	public void addEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item) {
		Validate.notNull(application, "EnrollmentApplication cannot be null");
		Validate.notNull(item, "Item cannot be null");
		Validate.isTrue(DRAFTED.equals(application.getFlowdata().getState()),
				"EnrollmentApplication can only be configured in DRAFTED state");
		enrollmentApplicationDao.addItem(application, item, securityService.getCurrentUser());
	}

	@Override
	public void updateEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item) {
		Validate.notNull(application, "EnrollmentApplication cannot be null");
		Validate.notNull(item, "Item cannot be null");
		Validate.isTrue(DRAFTED.equals(application.getFlowdata().getState()),
				"EnrollmentApplication can only be configured in DRAFTED state");
		enrollmentApplicationDao.updateItem(application, item, securityService.getCurrentUser());
	}

	@Override
	public void deleteEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item) {
		Validate.notNull(application, "EnrollmentApplication cannot be null");
		Validate.notNull(item, "Item cannot be null");
		Validate.isTrue(DRAFTED.equals(application.getFlowdata().getState()),
				"EnrollmentApplication can only be configured in DRAFTED state");
		enrollmentApplicationDao.deleteItem(application, item, securityService.getCurrentUser());
	}

	@Override
	public AdEnrollmentApplication findEnrollmentApplicationById(Long id) {
		return enrollmentApplicationDao.findById(id);
	}

	@Override
	public AdEnrollmentApplication findEnrollmentApplicationByReferenceNo(String referenceNo) {
		return enrollmentApplicationDao.findByReferenceNo(referenceNo);
	}

	@Override
	public AdEnrollmentApplicationItem findEnrollmentApplicationItemById(Long id) {
		return enrollmentApplicationDao.findItemById(id);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session) {
		return enrollmentApplicationDao.find(session);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session, Integer offset,
			Integer limit) {
		return enrollmentApplicationDao.find(session, offset, limit);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session,
			Integer offset, Integer limit) {
		return enrollmentApplicationDao.find(filter, session, offset, limit);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session,
			AdStudent student, Integer offset, Integer limit) {
		return enrollmentApplicationDao.find(filter, session, student, offset, limit);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session,
			AdStaff advisor, Integer offset, Integer limit) {
		return enrollmentApplicationDao.find(filter, session, advisor, offset, limit);
	}

	@Override
	public List<AdEnrollmentApplicationItem> findEnrollmentApplicationItems(AdEnrollmentApplication application) {
		return enrollmentApplicationDao.findItems(application);
	}

	@Override
	public Integer countEnrollmentApplication(AdAcademicSession session) {
		return enrollmentApplicationDao.count(session);
	}

	@Override
	public Integer countEnrollmentApplication(String filter, AdAcademicSession session) {
		return enrollmentApplicationDao.count(filter, session);
	}

	@Override
	public Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStudent student) {
		return enrollmentApplicationDao.count(filter, session, student);
	}

	@Override
	public Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStaff staff) {
		return enrollmentApplicationDao.count(filter, session, staff);
	}

	// ====================================================================================================
	// ENROLLMENT
	// ====================================================================================================

	@Override
	public AdEnrollment findEnrollmentById(Long id) {
		return enrollmentDao.findById(id);
	}

	@Override
	public AdEnrollment findEnrollmentBySectionAndStudent(AdSection section, AdStudent student) {
		return enrollmentDao.findBySectionAndStudent(section, student);
	}

	@Override
	public AdEnrollment findEnrollmentByMatricNoAndOffering(String matricNo, AdOffering offering) {
		return enrollmentDao.findByMatricNoAndOffering(matricNo, offering);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdAdmission admission) {
		return enrollmentDao.find(admission);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession) {
		return enrollmentDao.find(academicSession);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdProgram program) {
		return enrollmentDao.find(academicSession, program);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdProgram program) {
		return enrollmentDao.find(program);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdOffering offering) {
		return enrollmentDao.find(offering);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdSection section) {
		return enrollmentDao.find(section);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdStudent student) {
		return enrollmentDao.find(student);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdOffering offering, Integer offset, Integer limit) {
		return enrollmentDao.find(offering, offset, limit);
	}

	@Override
	public List<AdEnrollment> findEnrollments(String filter, AdOffering offering, Integer offset, Integer limit) {
		return enrollmentDao.find(filter, offering, offset, limit);
	}

	@Override
	public List<AdEnrollment> findEnrollments(String filter, AdAcademicSession academicSession, AdOffering offering,
			Integer offset, Integer limit) {
		return enrollmentDao.find(filter, academicSession, offering, offset, limit);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdOffering offering) {
		return enrollmentDao.find(academicSession, offering);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdStudent student) {
		return enrollmentDao.find(academicSession, student);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdOffering offering, Integer offset,
			Integer limit) {
		return enrollmentDao.find(academicSession, offering, offset, limit);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdStudent student, Integer offset, Integer limit) {
		return enrollmentDao.find(student, offset, limit);
	}

	@Override
	public List<AdEnrollment> findEnrollments(AdSection section, Integer offset, Integer limit) {
		return enrollmentDao.find(section, offset, limit);
	}

	@Override
	public List<AdEnrollment> findEnrollments(String filter, AdSection section, Integer offset, Integer limit) {
		return enrollmentDao.find(filter, section, offset, limit);
	}

	@Override
	public Integer countEnrollment(AdOffering offering) {
		return enrollmentDao.count(offering);
	}

	@Override
	public Integer countEnrollment(AdAcademicSession academicSession, AdOffering offering) {
		return enrollmentDao.count(academicSession, offering);
	}

	@Override
	public Integer countEnrollment(String filter, AdOffering offering) {
		return enrollmentDao.count(filter, offering);
	}

	@Override
	public Integer countEnrollment(String filter, AdAcademicSession academicSession, AdOffering offering) {
		return enrollmentDao.count(filter, academicSession, offering);
	}

	@Override
	public Integer countEnrollment(AdSection section) {
		return enrollmentDao.count(section);
	}

	@Override
	public Integer countEnrollment(AdEnrollmentStatus status, AdSection section) {
		return enrollmentDao.count(status, section);
	}

	@Override
	public Integer countEnrollment(String filter, AdSection section) {
		return enrollmentDao.count(filter, section);
	}

	@Override
	public Integer countEnrollment(AdStudent student) {
		return enrollmentDao.count(student);
	}

	@Override
	public Integer countEnrollment(AdAdmission admission) {
		return enrollmentDao.count(admission);
	}

	@Override
	public boolean isAnyEnrollmentExists(AdAcademicSession academicSession, AdOffering offering, AdStudent student) {
		return enrollmentDao.isAnyExists(academicSession, offering, student);
	}

	@Override
	public boolean isEnrollmentExists(AdSection section, AdStudent student) {
		return enrollmentDao.isExists(section, student);
	}

	@Override
	public boolean hasEnrollment(AdSection section) {
		return enrollmentDao.hasEnrollment(section);
	}

	@Override
	public boolean hasExceededEnrollment(AdSection section) {
		Integer capacity = section.getCapacity();
		Integer confirmedEnrollment = countEnrollment(AdEnrollmentStatus.CONFIRMED, section);

		if (confirmedEnrollment >= capacity)
			return true;
		else
			return false;
	}

	// ====================================================================================================
	// ENROLLMENT
	// ====================================================================================================

	@Override
	public void enroll(boolean override, AdSection section, AdStudent student, AdAdmission admission) {
		LOG.debug("enrolling student #{} into section #{}", student.getMatricNo(), section.getCanonicalCode());
		Validate.notNull(section, "Section cannot be null");
		Validate.notNull(student, "Student cannot be null");

		if (isEnrollmentExists(section, student)) // todo(uda): throw something
													// here OfferingException

			// todo(uda): close for now
			// if (!override &&
			// mapManager.hasExceededCredit(dasFinder.findCurrentAcademicSession(),
			// student)) {
			// throw new EnrollmentException("Student exceed allowed credit
			// count");
			// }

			// if (override &&
			// mapManager.hasExceededCredit(dasFinder.findCurrentAcademicSession(),
			// student)) {
			// throw new EnrollmentException("Student exceed allowed credit
			// count");
			// }

			LOG.debug("section id: {}", section.getId());

		// find admission
		AdAcademicSession session = section.getSession();
		AdOffering offering = section.getOffering();

		// create enrollment
		AdEnrollment enrollment = new AdEnrollmentImpl();
		enrollment.setAdmission(admission);
		enrollment.setStudent(student);
		enrollment.setSection(section);
		enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
		saveEnrollment(enrollment);
		sessionFactory.getCurrentSession().refresh(enrollment);

		// TODO: check process calendar
		// TODO: PRA, WAJIB, BERDENDA
		AdAcademicSession academicSession = section.getSession();
		AdProgram program = admission.getProgram();
		AdStudyCenter studyCenter = admission.getStudyCenter();
		EnrollmentConfirmedEvent event = new EnrollmentConfirmedEvent();
		applicationContext.publishEvent(event);
	}

	@Override
	public void withdraw(boolean override, AdSection section, AdStudent student, AdAdmission admission) {
		// TODO: check process calendar
		// TODO: PRA, WAJIB, BERDENDA
		LOG.debug("withdrawing student #{} from section #{}", student.getMatricNo(), section.getCanonicalCode());

		AdEnrollment enrollment = findEnrollmentBySectionAndStudent(section, student);
		enrollment.setStatus(AdEnrollmentStatus.WITHDRAWN);
		updateEnrollment(enrollment);

		AdAcademicSession academicSession = section.getSession();
		AdProgram program = admission.getProgram();
		AdStudyCenter studyCenter = admission.getStudyCenter();
		AdCohort cohort = student.getCohort();
		EnrollmentWithdrawnEvent event = new EnrollmentWithdrawnEvent();
		applicationContext.publishEvent(event);
	}

	@Override
	public void saveEnrollment(AdEnrollment enrollment) {
		enrollmentDao.save(enrollment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateEnrollment(AdEnrollment enrollment) {
		enrollmentDao.update(enrollment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteEnrollment(AdEnrollment enrollment) {
		enrollmentDao.delete(enrollment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// public AcGroup getAdminGroup() {
	// return groupDao.findByName();
	// }

	// ====================================================================================================
	// BUSINESS PROCESS
	// ====================================================================================================

	@Override
	public void publishToEnrollment(AdEnrollmentApplication application) {
		Validate.notNull(application, "Application cannot be null");
		List<AdEnrollmentApplicationItem> items = findEnrollmentApplicationItems(application);
		for (AdEnrollmentApplicationItem item : items) {
			if (AdEnrollmentApplicationAction.ADD.equals(item.getAction()))
				enroll(true, item.getSection(), application.getStudent(), application.getAdmission());
			else if (AdEnrollmentApplicationAction.DROP.equals(item.getAction()))
				withdraw(true, item.getSection(), application.getStudent(), application.getAdmission());
			else
				LOG.warn("Not supposed to happen");
		}
	}

	@Override
	public void addGradebooks(AdSection section, AdEnrollment enrollment) {
		AdOffering offering = section.getOffering();
		AdAcademicSession session = section.getSession();
		Validate.notNull(offering, "Offering cannot be null");
		Validate.notNull(session, "Session cannot be null");

		// List<AdAssessment> assessments = findAssessments(session, term);
		// LOG.debug("assessments found: " + assessments.size());
		// for (AcAssessment assessment : assessments) {
		// if (!assessmentService.isGradebookExists(assessment, enrollment)) {
		// LOG.debug("section: " + section.getId());
		// AcGradebook gradebook = new AcGradebookImpl();
		// gradebook.setAssessment(assessment);
		// gradebook.setEnrollment(enrollment);
		// gradebook.setSection(section);
		// ptkManager.saveGradebook(gradebook);
		// }
		// }
	}

	@Override
	public void addGradebooks(AdSection section, AdAssessment assessment) {
		AdOffering offering = section.getOffering();
		AdAcademicSession session = section.getSession();
		Validate.notNull(offering, "Offering cannot be null");
		Validate.notNull(session, "Session cannot be null");
		List<AdEnrollment> enrollments = findEnrollments(section);
		LOG.debug("assessments found: " + enrollments.size());
		// todo(uda): figure out assessment
		// for (AdEnrollment enrollment : enrollments) {
		// if (!assessmentService.isGradebookExists(assessment, enrollment)) {
		// LOG.debug("section: " + section.getId());
		// AdGradebook gradebook = new AdGradebookImpl();
		// gradebook.setAssessment(assessment);
		// gradebook.setEnrollment(enrollment);
		// gradebook.setSection(section);
		// saveGradebook(gradebook);
		// }
		// }
	}

	// ====================================================================================================
	// APPOINTMENT
	// ====================================================================================================

	@Override
	public AdAppointment findAppointmentById(Long id) {
		return appointmentDao.findById(id);
	}

	@Override
	public AdAppointment findAppointmentBySectionAndStaff(AdSection section, AdStaff staff) {
		return appointmentDao.findBySectionAndStaff(section, staff);
	}

	@Override
	public List<AdAppointment> findAppointments(AdOffering offering) {
		return appointmentDao.find(offering);
	}

	@Override
	public List<AdAppointment> findAppointments(AdSection section) {
		return appointmentDao.find(section);
	}

	@Override
	public List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdOffering offering) {
		return appointmentDao.find(academicSession, offering);
	}

	@Override
	public List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdStaff staff) {
		return appointmentDao.find(academicSession, staff);
	}

	@Override
	public List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdStaff staff, Integer offset,
			Integer limit) {
		return appointmentDao.find(academicSession, staff, offset, limit);
	}

	@Override
	public List<AdAppointment> findAppointments(AdSection section, Integer offset, Integer limit) {
		return appointmentDao.find(section, offset, limit);
	}

	@Override
	public Integer countAppointment(AdSection section) {
		return appointmentDao.count(section);
	}

	@Override
	public Integer countAppointment(AdAcademicSession academicSession, AdOffering offering) {
		return appointmentDao.count(academicSession, offering);
	}

	@Override
	public Integer countAppointment(AdAcademicSession academicSession, AdStaff staff) {
		return appointmentDao.count(academicSession, staff);
	}

	@Override
	public boolean hasAppointment(AdSection section) {
		return appointmentDao.hasAppointment(section);
	}

	@Override
	public boolean isAppointmentExists(AdSection section, AdStaff staff) {
		return appointmentDao.isExists(section, staff);
	}

	@Override
	public boolean isAnyAppointmentExists(AdAcademicSession academicSession, AdOffering offering, AdStaff staff) {
		return appointmentDao.isAnyExists(academicSession, offering, staff);
	}

	@Override
	public void appoint(AdSection section, AdStaff staff) {
		// todo(uda): throw error on appointment exists
		// todo(uda): throw error on appointment clash

		AdAppointment appointment = new AdAppointmentImpl();
		appointment.setStaff(staff);
		appointment.setSection(section);
		appointment.setStatus(AdAppointmentStatus.CONFIRMED);
		sectionDao.addAppointment(section, appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(appointment);

		AppointmentConfirmedEvent event = new AppointmentConfirmedEvent();
		applicationContext.publishEvent(event);
	}

	@Override
	public void dismiss(AdSection section, AdStaff staff) {
		// todo(uda): throw error on appointment not exists
		AdAppointment appointment = appointmentDao.findBySectionAndStaff(section, staff);
		appointment.setStatus(AdAppointmentStatus.DISMISSED);
		sectionDao.updateAppointment(section, appointment, securityService.getCurrentUser());

		AppointmentDismissedEvent event = new AppointmentDismissedEvent();
		applicationContext.publishEvent(event);
	}

	@Override
	public void saveAppointment(AdAppointment appointment) {
		appointmentDao.save(appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateAppointment(AdAppointment appointment) {
		appointmentDao.update(appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteAppointment(AdAppointment appointment) {
		appointmentDao.delete(appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// PRIVATE METHODS
	// ====================================================================================================

	private Map<String, Object> prepareVariables(AdEnrollmentApplication application) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ENROLLMENT_APPLICATION_ID, application.getId());
		map.put(WorkflowConstants.USER_CREATOR, securityService.getCurrentUser().getName());
		map.put(WorkflowConstants.REFERENCE_NO, application.getReferenceNo());
		map.put(WorkflowConstants.REMOVE_DECISION, false);
		map.put(WorkflowConstants.CANCEL_DECISION, false);
		return map;
	}

}
