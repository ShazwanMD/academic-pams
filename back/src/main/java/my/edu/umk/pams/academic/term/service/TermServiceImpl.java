package my.edu.umk.pams.academic.term.service;

import my.edu.umk.pams.academic.common.model.AdGradeCode;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static my.edu.umk.pams.academic.AcademicConstants.*;
import static my.edu.umk.pams.academic.core.AdFlowState.COMPLETED;
import static my.edu.umk.pams.academic.core.AdFlowState.DRAFTED;

/**
 * @author PAMS
 */
@Transactional
@Service("termService")
public class TermServiceImpl implements TermService {

	private static final Logger LOG = LoggerFactory.getLogger(TermServiceImpl.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private AdOfferingDao offeringDao;

	@Autowired
	private AdSectionDao sectionDao;

	@Autowired
	private AdAdmissionApplicationDao admissionApplicationDao;

	@Autowired
	private AdAdmissionDao admissionDao;

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

	private AdGradeCode grade;

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
		return null; // todo:
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
	public boolean isOfferingExists(String canonicalCode) {
				  return offeringDao.isExists(canonicalCode);
	}
	
	@Override
	public void saveOffering(AdOffering offering) {
		if (isOfferingExists(offering.getCanonicalCode())) {
			System.out.println ("Duplicate offering record");							
		} else {
		
		offeringDao.save(offering, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		}
	}
	
 

/* @Override
 	public void saveOffering(AdOffering offering) throws Exception {
      if (isOfferingExists(offering.getCanonicalCode()))
       throws new Exception("Duplicate offering record");
	            
       offeringDao.save(offering, securityService.getCurrentUser());
	        sessionFactory.getCurrentSession().flush();
	    }*/

	@Override
	public void updateOffering(AdOffering offering) {
		offeringDao.update(offering, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	public void calculateGradebook(AdOffering offering) {
		List<AdEnrollment> enrollments = findEnrollments(offering);
		for (AdEnrollment enrollment : enrollments) {
			List<AdGradebook> gradebooks = findGradebooks(enrollment);
			LOG.debug("Found " + gradebooks.size() + " gradebooks");
			BigDecimal totalScore = BigDecimal.ZERO;
			for (AdGradebook gradebook : gradebooks) {
				BigDecimal assessmentScore = gradebook.getScore().multiply(gradebook.getAssessment().getWeight())
						.divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
				totalScore = totalScore.add(assessmentScore);

			}
			enrollment.setTotalScore(totalScore);
			updateEnrollment(enrollment.getSection(), enrollment);
			
			// convert total score to gradecode  A, B, C, 
//			enrollment.setGradeCode(lookupGradeCode(totalScore));
//			commonService.findGradeCodes()
		}
		
	}
	
//	private AdGradeCode lookupGradeCode(BigDecimal totalScore){
//		if(totalScore >-)
//	}
	
	public void calculate(AdAcademicSession academicSession, AdOffering offering){
	   List<AdEnrollment> enrollments = findEnrollments(offering);
       for (AdEnrollment enrollment : enrollments) {
           calculateGradebook(offering);
           enrollment.setGradeCode( commonService.findByScore(enrollment.getTotalScore()));
           updateEnrollment(enrollment.getSection(), enrollment);
           
           List<AdAdmission> Admissions = findAdmissions(academicSession);
           for (AdAdmission adAdmission : Admissions) {
				plannerService.calculateGpa(academicSession, adAdmission);
			}
                   
		}
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

	@Deprecated
	@Override
	public void saveSection(AdSection section) {
		sectionDao.save(section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addSection(AdOffering offering, AdSection section) {
		section.setOffering(offering);
		offeringDao.addSection(offering, section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteSection(AdOffering offering, AdSection section) {
		offeringDao.deleteSection(offering, section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateSection(AdOffering offering, AdSection section) {
		offeringDao.updateSection(offering, section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeSection(AdOffering offering, AdSection section) {
		offeringDao.removeSection(offering, section, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// ASSESSMENT
	// ====================================================================================================
	@Override
	public AdAssessment findAssessmentById(Long id) {
		return assessmentDao.findAssessmentById(id);
	}

	@Override
	public AdAssessment findAssessmentByCanonicalCode(String canonicalCode) {
		return assessmentDao.findByCanonicalCode(canonicalCode);
	}

	public AdAssessment findAssessmentByCodeAndOffering(String code, AdOffering offering) {
		return assessmentDao.findByCodeAndOffering(code, offering);
	}

	@Override
	public List<AdAssessment> findAssessments(AdOffering offering) {
		return assessmentDao.find(offering);
	}

	@Override
	public List<AdAssessment> findAssessments(Integer offset, Integer limit) {
		return assessmentDao.find(offset, limit);
	}

	@Override
	public List<AdAssessment> findAssessments(AdOffering offering, Integer offset, Integer limit) {
		return assessmentDao.find(offering, offset, limit);
	}

	@Override
	public Integer countAssessment(AdOffering offering) {
		return assessmentDao.count(offering);
	}

	@Override
	public Integer countAssessment(AdOffering offering, AdAssessmentType type) {
		return assessmentDao.count(offering, type);
	}

	@Override
	public boolean hasAssessment(AdOffering offering) {
		return assessmentDao.hasAssessment(offering);
	}

	@Override
	public boolean isAssessmentExists(String canonicalCode, AdOffering offering) {
		return assessmentDao.isExists(canonicalCode, offering);
	}

	@Override
	public boolean isAssessmentExists(String canonicalCode) {
		return assessmentDao.isExists(canonicalCode);
	}

	@Override
	public void initAssessment(AdOffering offering, AdAssessment assessment) {
		// if (assessmentDao.isExists(assessment.getCanonicalCode()))
		// throw new AssessmentException();

		assessment.setOffering(offering);
		assessmentDao.save(assessment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(assessment);
		// AssessmentConfirmedEvent event = new
		// AssessmentConfirmedEvent(academicSession, offering, assessment);
		// applicationContext.publishEvent(event);
	}

	@Override
	public void addAssessment(AdOffering offering, AdAssessment assessment) {
		assessment.setOffering(offering);
		assessmentDao.save(assessment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateAssessment(AdOffering offering, AdAssessment assessment) {
		offeringDao.updateAssessment(offering, assessment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteAssessment(AdOffering offering, AdAssessment assessment) {
		offeringDao.deleteAssessment(offering, assessment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// ADMISSION APPLICATION
	// ====================================================================================================

	// workflow
	@Override
	public AdAdmissionApplication findAdmissionApplicationByTaskId(String taskId) {
		Task task = workflowService.findTask(taskId);
		Map<String, Object> map = workflowService.getVariables(task.getExecutionId());
		return admissionApplicationDao.findById((Long) map.get(ADMISSION_APPLICATION_ID));
	}

	@Override
	public Task findAdmissionApplicationTaskByTaskId(String taskId) {
		return workflowService.findTask(taskId);
	}

	@Override
	public List<Task> findAssignedAdmissionApplicationTasks(Integer offset, Integer limit) {
		return workflowService.findAssignedTasks(AdAdmissionApplication.class.getName(), offset, limit);
	}

	@Override
	public List<Task> findPooledAdmissionApplicationTasks(Integer offset, Integer limit) {
		return workflowService.findPooledTasks(AdAdmissionApplication.class.getName(), offset, limit);
	}

	@Override
	public Integer countAssignedAdmissionApplicationTasks() {
		return workflowService.countAssignedTask(AdAdmissionApplication.class.getName());
	}

	@Override
	public Integer countPooledAdmissionApplicationTasks() {
		return workflowService.countPooledTask(AdAdmissionApplication.class.getName());
	}

	@Override
	public String startAdmissionApplicationTask(AdAdmissionApplication application) {
		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(ADMISSION_APPLICATION_REFERENCE_NO, param);
		application.setReferenceNo(refNo);

		LOG.debug("saving application with refno {}", refNo);

		admissionApplicationDao.save(application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(application);

		// trigger workflow
		workflowService.processWorkflow(application, prepareVariables(application));
		return refNo;
	}

	@Override
	public void updateAdmissionApplication(AdAdmissionApplication application) {
		admissionApplicationDao.update(application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateAdmission(AdAdmission admission) {
		admissionDao.update(admission, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void cancelAdmissionApplication(AdAdmissionApplication application) {
		Validate.notNull(application, "EnrollmentApplication cannot be null");
		Validate.isTrue(COMPLETED.equals(application.getFlowdata().getState()),
				"Admission Application can only be cancelled in COMPLETED state");
		admissionApplicationDao.update(application, securityService.getCurrentUser());
	}

	@Override
	public void postToAdmission(AdAdmissionApplication application) {
		Validate.notNull(application, "Application cannot be null");
		admit(application.getSession(), application.getStudent(), application.getStudyCenter(),
				application.getProgram());
	}

	@Override
	public AdAdmissionApplication findAdmissionApplicationById(Long id) {
		return admissionApplicationDao.findById(id);
	}

	@Override
	public AdAdmissionApplication findAdmissionApplicationByReferenceNo(String referenceNo) {
		return admissionApplicationDao.findByReferenceNo(referenceNo);
	}

	@Override
	public AdAdmissionApplication findAdmissionApplicationByProgramAndStudent(AdProgram program, AdStudent student) {
		return admissionApplicationDao.findByProgramAndStudent(program, student);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplicationsByFlowState(AdFlowState flowState) {
		return admissionApplicationDao.findByFlowState(flowState);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplicationsByFlowStates(AdFlowState... flowStates) {
		return admissionApplicationDao.findByFlowStates(flowStates);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplications(AdAcademicSession session) {
		return admissionApplicationDao.find(session);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplications(AdAcademicSession session, Integer offset,
			Integer limit) {
		return admissionApplicationDao.find(session, offset, limit);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session,
			Integer offset, Integer limit) {
		return admissionApplicationDao.find(filter, session, offset, limit);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session,
			AdStudent student, Integer offset, Integer limit) {
		return admissionApplicationDao.find(filter, session, student, offset, limit);
	}

	@Override
	public List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session,
			AdStaff advisor, Integer offset, Integer limit) {
		return null; // todo
	}

	@Override
	public Integer countAdmissionApplication(AdAcademicSession session) {
		return admissionApplicationDao.count(session);
	}

	@Override
	public Integer countAdmissionApplication(String filter, AdAcademicSession session) {
		return admissionApplicationDao.count(filter, session);
	}

	@Override
	public Integer countAdmissionApplication(String filter, AdAcademicSession session, AdStudent student) {
		return admissionApplicationDao.count(filter, session, student);
	}

	@Override
	public Integer countAdmissionApplication(String filter, AdAcademicSession session, AdStaff staff) {
		return admissionApplicationDao.count(filter, session, staff);
	}

	@Override
	public void saveAdmissionApplication(AdAdmissionApplication application) {
		admissionApplicationDao.save(application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// ADMISSION
	// ====================================================================================================

	@Override
	public AdAdmission findAdmissionById(Long id) {
		return admissionDao.findById(id);
	}

	@Override
	public AdAdmission findAdmissionByAcademicSessionCohortAndStudent(AdAcademicSession academicSession,
			AdCohort cohort, AdStudent student) {
		return admissionDao.findBySessionCohortAndStudent(academicSession, cohort, student);
	}

	@Override
	public List<AdAdmission> findAdmissions(Integer offset, Integer limit) {
		return admissionDao.find(offset, limit);
	}

	@Override
	public List<AdAdmission> findAdmissions(AdAcademicSession academicSession, Integer offset, Integer limit) {
		return admissionDao.find(academicSession); // todo: limit/offset
	}
	
	@Override
	public List<AdAdmission> findAdmissions(AdAcademicSession academicSession) {
		return admissionDao.find(academicSession);
	}

	@Override
	public Integer countAdmission(AdAcademicSession academicSession, AdStudent student) {
		return admissionDao.count(academicSession, student);
	}

	@Override
	public void saveAdmission(AdAdmission admission) {
		admissionDao.save(admission, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void admit(AdAcademicSession session, AdStudent student, AdStudyCenter studyCenter, AdProgram program) {
		AdAdmission admission = new AdAdmissionImpl();
		admission.setSession(session);
		admission.setStudent(student);
		admission.setStudyCenter(studyCenter);
		admission.setStanding(AdAcademicStanding.TBD);
		admission.setCreditEarned(0);
		admission.setCreditTaken(0);
		admission.setCgpa(BigDecimal.ZERO); // todo
		admission.setGpa(BigDecimal.ZERO); // todo
		admission.setCohort(student.getCohort());
		saveAdmission(admission);
		sessionFactory.getCurrentSession().refresh(admission);

		// trigger event
		// todo:
		// AdmissionConfirmedEvent event = new AdmissionConfirmedEvent();
		// applicationContext.publishEvent(event);
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
	public String startEnrollmentApplicationTask(AdEnrollmentApplication application) {
		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(ENROLLMENT_APPLICATION_REFERENCE_NO, param);
		application.setReferenceNo(refNo);

		enrollmentApplicationDao.save(application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(application);

		// trigger workflow
		workflowService.processWorkflow(application, prepareVariables(application));
		return refNo;
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
	public AdEnrollmentApplicationItem findEnrollmentApplicationItemBySection(AdSection section) {
		return enrollmentApplicationDao.findItemBySection(section);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplicationsByFlowState(AdFlowState flowState) {
		return enrollmentApplicationDao.findByFlowState(flowState);
	}

	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplicationsByFlowStates(AdFlowState... flowStates) {
		return enrollmentApplicationDao.findByFlowStates(flowStates);
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

	// find enrollmentApplications by admission created 18/6/17
	@Override
	public List<AdEnrollmentApplication> findEnrollmentApplications(AdAdmission admission) {
		return enrollmentApplicationDao.find(admission);
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
	public List<AdEnrollment> findEnrollments(Integer offset, Integer limit) {
		return enrollmentDao.find(offset, limit);
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
	public void enroll(boolean override, AdSection section, AdAdmission admission) {
		AdStudent student = admission.getStudent();
		LOG.debug("enrolling student #{} into section #{}", student.getMatricNo(), section.getCanonicalCode());
		Validate.notNull(section, "Section cannot be null");
		Validate.notNull(student, "Student cannot be null");

		if (!isEnrollmentExists(section, student)) {// todo(uda): throw
													// something here
													// OfferingException
			LOG.debug("section id: {}", section.getId());

			// find admission
			AdOffering offering = section.getOffering();

			// create enrollment
			AdEnrollment enrollment = new AdEnrollmentImpl();
			enrollment.setAdmission(admission);
			enrollment.setSection(section);
			enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
			saveEnrollment(enrollment);
			sessionFactory.getCurrentSession().refresh(enrollment);

			// AdStudyCenter studyCenter = admission.getStudyCenter();
			EnrollmentConfirmedEvent event = new EnrollmentConfirmedEvent(enrollment);
			applicationContext.publishEvent(event);
		}
	}

	@Override
	public void withdraw(boolean override, AdSection section, AdAdmission admission) {
		// TODO: check process calendar
		// TODO: PRA, WAJIB, BERDENDA
		AdStudent student = admission.getStudent();
		LOG.debug("withdrawing student #{} from section #{}", student.getMatricNo(), section.getCanonicalCode());

		AdEnrollment enrollment = findEnrollmentBySectionAndStudent(section, student);
		enrollment.setStatus(AdEnrollmentStatus.WITHDRAWN);
		updateEnrollment(section, enrollment);

		AdStudyCenter studyCenter = admission.getStudyCenter();
		AdCohort cohort = student.getCohort();
		EnrollmentWithdrawnEvent event = new EnrollmentWithdrawnEvent(enrollment);
		applicationContext.publishEvent(event);
	}

	@Override
	public void saveEnrollment(AdEnrollment enrollment) {
		enrollmentDao.save(enrollment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// update enrollment by section
	@Override
	public void updateEnrollment(AdSection section, AdEnrollment enrollment) {
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
	public void postToEnrollment(AdEnrollmentApplication application) {
		Validate.notNull(application, "Application cannot be null");
		List<AdEnrollmentApplicationItem> items = findEnrollmentApplicationItems(application);
		for (AdEnrollmentApplicationItem item : items) {
			if (AdEnrollmentApplicationAction.ADD.equals(item.getAction()))
				enroll(true, item.getSection(), application.getAdmission());
			else if (AdEnrollmentApplicationAction.DROP.equals(item.getAction()))
				withdraw(true, item.getSection(), application.getAdmission());
			else
				LOG.warn("Not supposed to happen");
		}
	}

	@Override
	public void addGradebook(AdSection section, AdEnrollment enrollment, AdGradebook gradebook) {
		Validate.notNull(section, "Section cannot be null");
		Validate.notNull(enrollment, "Enrollment cannot be null");
		Validate.notNull(gradebook, "Gradebook cannot be null");
		gradebookDao.addGradebook(section, enrollment, gradebook);
		sessionFactory.getCurrentSession().flush();
	}

	@Deprecated
	@Override
	public void addGradebook(AdSection section, AdAssessment assessment) {
		AdOffering offering = section.getOffering();
		Validate.notNull(offering, "Offering cannot be null");
		List<AdEnrollment> enrollments = findEnrollments(section);
		LOG.debug("assessments found: " + enrollments.size());
		sessionFactory.getCurrentSession().flush();
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
	public List<AdAppointment> findAppointments(AdAcademicSession academicSession) {
		return appointmentDao.find(academicSession);
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
	public void addAppointment(AdSection section, AdAppointment appointment) {
		appointment.setSection(section);
		appointmentDao.save(appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// update appointment by section
	@Override
	public void updateAppointment(AdSection section, AdAppointment appointment) {
		appointmentDao.update(appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteAppointment(AdAppointment appointment) {
		appointmentDao.delete(appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// remove appointment by section
	@Override
	public void removeAppointment(AdSection section, AdAppointment appointment) {
		sectionDao.removeAppointment(section, appointment, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public AdGradebook findGradebookById(Long id) {
		return gradebookDao.findById(id);
	}

	@Override
	public AdGradebook findGradebookByAssessmentAndEnrollment(AdAssessment assessment, AdEnrollment enrollment) {
		return gradebookDao.findByAssessmentAndEnrollment(assessment, enrollment);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdEnrollment enrollment) {
		return gradebookDao.find(enrollment);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdOffering offering) {
		return gradebookDao.find(offering);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdOffering offering, Integer offset, Integer limit) {
		return gradebookDao.find(offering, offset, limit);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdSection section) {
		return gradebookDao.find(section);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdSection section, AdAssessment assessment) {
		return gradebookDao.find(section, assessment);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdSection section, Integer offset, Integer limit) {
		return gradebookDao.find(section, offset, limit);
	}

	public List<AdGradebook> findGradebooks(AdSection section, AdAssessment assessment, Integer offset, Integer limit) {
		return gradebookDao.find(section, assessment, offset, limit);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdAssessment assessment) {
		return gradebookDao.find(assessment);
	}

	@Override
	public List<AdGradebook> findGradebooks(AdAssessment assessment, Integer offset, Integer limit) {
		return gradebookDao.find(assessment, offset, limit);
	}

	@Override
	public Integer countGradebook(AdSection section, AdAssessment assessment) {
		return gradebookDao.count(section, assessment);
	}

	@Override
	public boolean isGradebookExists(AdAssessment assessment, AdEnrollment enrollment) {
		return gradebookDao.isExists(assessment, enrollment);
	}

	@Override
	public boolean hasGradebook(AdSection section, AdAssessment assessment) {
		return assessmentDao.hasGradebook(section, assessment);
	}

	@Override
	public void saveGradebook(AdGradebook gradebook) {
		gradebookDao.save(gradebook, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateGradebook(AdGradebook gradebook) {
		gradebookDao.update(gradebook, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteGradebook(AdGradebook gradebook) {
		gradebookDao.delete(gradebook, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	/**
	 * score = 90, totalScore=100, weight 40 90 /100 x 100 x 40/100 = 90x40/100
	 *
	 * @param enrollment
	 * @return
	 */
	@Override
	public BigDecimal normalizeGradebooks(AdEnrollment enrollment) {
		List<AdGradebook> gradebooks = findGradebooks(enrollment);
		BigDecimal finalScore = BigDecimal.ZERO;
		for (AdGradebook gradebook : gradebooks) {
			BigDecimal score = gradebook.getScore();
			BigDecimal totalScore = gradebook.getAssessment().getTotalScore();
			BigDecimal weight = gradebook.getAssessment().getWeight();
			LOG.debug("score: {} totalScore: {}, weight: {} ", new Object[] { score, totalScore, weight });

			BigDecimal normalizedScore = score.divide(totalScore).setScale(1, RoundingMode.HALF_UP)
					.multiply(BigDecimal.valueOf(100)).multiply(weight).divide(BigDecimal.valueOf(100))
					.setScale(1, RoundingMode.HALF_UP);

			finalScore = finalScore.add(normalizedScore);
			LOG.debug("normalizedScore: {}", normalizedScore);

			if (score.doubleValue() >= 90 && score.doubleValue() <= 100) {

				// logging

				grade = commonService.findGradeCodeByCode("A+");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 80 && score.doubleValue() <= 89) {

				grade = commonService.findGradeCodeByCode("A");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 75 && score.doubleValue() <= 79) {

				grade = commonService.findGradeCodeByCode("A-");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 70 && score.doubleValue() <= 74) {

				grade = commonService.findGradeCodeByCode("B+");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 65 && score.doubleValue() <= 69) {

				grade = commonService.findGradeCodeByCode("B");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 60 && score.doubleValue() <= 64) {

				grade = commonService.findGradeCodeByCode("B-");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 55 && score.doubleValue() <= 59) {

				grade = commonService.findGradeCodeByCode("C+");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 50 && score.doubleValue() <= 54) {

				grade = commonService.findGradeCodeByCode("C");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 45 && score.doubleValue() <= 49) {

				grade = commonService.findGradeCodeByCode("C-");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 40 && score.doubleValue() <= 44) {
				grade = commonService.findGradeCodeByCode("D");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() >= 0 && score.doubleValue() <= 39) {

				grade = commonService.findGradeCodeByCode("F");
				LOG.debug("Mark :{}", score);
				LOG.debug("Grade :{}", grade.getCode());
				LOG.debug("Ordinal :{}", grade.getOrdinal());
				LOG.debug("Grade Desc :{}", grade.getDescription());

			} else if (score.doubleValue() > 100) {

				LOG.debug("Mark :{}", score.doubleValue());
				LOG.debug("Cannot More than 100% marks");

			} else if (score.doubleValue() < 0) {

				LOG.debug("Mark :{}", score);
				LOG.debug("Cannot Less than 0% marks");
			}

		}
		LOG.debug("finalScore: {}", finalScore);
		return finalScore.setScale(2);

	}

	// ====================================================================================================
	// PRIVATE METHODS
	// ====================================================================================================

	private Map<String, Object> prepareVariables(AdAdmissionApplication application) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ADMISSION_APPLICATION_ID, application.getId());
		map.put(WorkflowConstants.USER_CREATOR, securityService.getCurrentUser().getName());
		map.put(WorkflowConstants.REFERENCE_NO, application.getReferenceNo());
		map.put(WorkflowConstants.REMOVE_DECISION, false);
		map.put(WorkflowConstants.CANCEL_DECISION, false);
		return map;
	}

	private Map<String, Object> prepareVariables(AdEnrollmentApplication application) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ENROLLMENT_APPLICATION_ID, application.getId());
		map.put(WorkflowConstants.USER_CREATOR, securityService.getCurrentUser().getName());
		map.put(WorkflowConstants.REFERENCE_NO, application.getReferenceNo());
		map.put(WorkflowConstants.REMOVE_DECISION, false);
		map.put(WorkflowConstants.CANCEL_DECISION, false);
		return map;
	}

	@Override
	public void removeEnrollmentApplication(AdAdmission admission, AdEnrollmentApplication application) {
		admissionDao.removeEnrollmentApplication(admission, application, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	
}
