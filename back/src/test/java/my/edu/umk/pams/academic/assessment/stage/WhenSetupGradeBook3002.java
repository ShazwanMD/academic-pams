package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdGradebookImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenSetupGradeBook3002 extends Stage<WhenSetupGradeBook3002> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenSetupGradeBook3002.class);
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAssessment assessment;

	@ExpectedScenarioState
	private AdAcademicSession session;

	@ExpectedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdAdmission admission;

	@ExpectedScenarioState
	private AdStudyCenter studyCenter;

	@ExpectedScenarioState
	private AdCohort cohort;

	@ExpectedScenarioState
	private AdGradeCode grade;

	@ExpectedScenarioState
	private AdGradebook gradebook;

	@ExpectedScenarioState
	private AdOffering offer;
	
	
	public WhenSetupGradeBook3002 generate_gradebook(){
		
		student = profileService.findStudentByMatricNo("A17P003");

		session = plannerService.findCurrentAcademicSession();

		cohort = student.getCohort();

		studyCenter = commonService.findStudyCenterByCode("A");

		admission = new AdAdmissionImpl();

		admission.setGpa(BigDecimal.valueOf(2.75));
		admission.setCgpa(BigDecimal.valueOf(3.00));
		admission.setCreditTaken(3);
		admission.setCreditEarned(3);
		admission.setStudent(student);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		admission.setStanding(AdAcademicStanding.KB);
		admission.setStudyCenter(studyCenter);
		admission.setSession(session);
		admission.setCohort(cohort);
		termService.saveAdmission(admission);
		LOG.debug("Admission Student Name :{}", admission.getStudent().getName());
		LOG.debug("Admission academic session :{}", admission.getSession().getCode());
		LOG.debug("Admission study center :{}", admission.getStudyCenter().getDescription());
		LOG.debug("Admission cohort :{}", admission.getCohort().getCode());
		LOG.debug("Credit Taken :{}", admission.getCreditTaken());
		LOG.debug("Credit Earned :{}", admission.getCreditEarned());
		LOG.debug("Admission Status :{}", admission.getStatus().name());
		LOG.debug("Academic Standing :{}", admission.getStanding().name());
		LOG.debug("GPA :{}", admission.getGpa());
		LOG.debug("CGPA :{}", admission.getCgpa());
		LOG.debug("");

		enrollment = new AdEnrollmentImpl();
		enrollment.setAdmission(admission);
		enrollment.setSection(section);
		enrollment.setGradeCode(commonService.findGradeCodeByCode("A"));
		enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
		LOG.debug("Enrollment Status :{}", enrollment.getAdmission().getStanding().getDescription());
		LOG.debug("Grade Code :{}", enrollment.getGradeCode().getCode());
		termService.saveEnrollment(enrollment);
		

		AdAssessment Quiz1 = termService.findAssessmentByCanonicalCode("MASTER/MBA/GST5013/201720181/Q1");
		gradebook = new AdGradebookImpl();
		gradebook.setAssessment(Quiz1);
		LOG.debug("Gradebook Assessment Quiz 1 :{}", gradebook.getAssessment().getCanonicalCode());
		Assert.notNull(assessment, "Assessment Must Not Null");
		
		gradebook.setEnrollment(enrollment);
		Assert.notNull(enrollment, "enrollment Must Not Null");
		
		gradebook.setSection(section);
		Assert.notNull(section, "section Must Not Null");
		
		gradebook.setScore(new BigDecimal(BigInteger.valueOf(50)));

		termService.saveGradebook(gradebook);

		
		
		
		AdAssessment Test1 = termService.findAssessmentByCanonicalCode("MASTER/MBA/GST5013/201720181/T1");
		gradebook = new AdGradebookImpl();
		gradebook.setAssessment(Test1);
		LOG.debug("Gradebook Assessment Test 1 :{}", gradebook.getAssessment().getCanonicalCode());
		Assert.notNull(assessment, "Assessment Must Not Null");
		
		gradebook.setEnrollment(enrollment);
		Assert.notNull(enrollment, "enrollment Must Not Null");
		
		gradebook.setSection(section);
		Assert.notNull(section, "section Must Not Null");
		
		gradebook.setScore(new BigDecimal(BigInteger.valueOf(50)));

		termService.saveGradebook(gradebook);

		

		
		AdAssessment FinalExam = termService.findAssessmentByCanonicalCode("MASTER/MBA/GST5013/201720181/F1");
		gradebook = new AdGradebookImpl();
		gradebook.setAssessment(FinalExam);
		LOG.debug("Gradebook Assessment Final Exam :{}", gradebook.getAssessment().getCanonicalCode());
		Assert.notNull(assessment, "Assessment Must Not Null");
		
		gradebook.setEnrollment(enrollment);
		Assert.notNull(enrollment, "enrollment Must Not Null");
		
		gradebook.setSection(section);
		Assert.notNull(section, "section Must Not Null");
	
		gradebook.setScore(BigDecimal.valueOf(43.9));
		
		termService.saveGradebook(gradebook);

		termService.normalizeGradebooks(enrollment);

		
				
		
		
		
		

		
		
		
		
		
		return self();
	}

}
