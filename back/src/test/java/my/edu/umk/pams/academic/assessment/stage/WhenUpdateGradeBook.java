package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdGradebookImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.springframework.util.Assert;

@JGivenStage
public class WhenUpdateGradeBook extends Stage<WhenUpdateGradeBook> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenUpdateGradeBook.class);

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
	private AdOffering offering;

	public WhenUpdateGradeBook update_gradeBook() {
		Assert.notNull(assessment, "Assessment cannot be null");
		Assert.notNull(enrollment, "Enrollment cannot be null");
		Assert.notNull(section, "Section cannot be null");

		//Setup 2 gradebooks for each assessment
		createGradebook("MASTER-MBA-GST5013-201720181-Q1");
		createGradebook("MASTER-MBA-GST5013-201720181-Q2");

		termService.calculateGradebook(offering);
		LOG.debug("Enrollment_Total_Score:{}",enrollment.getTotalScore());
		
		AdGradeCode gradeCode = commonService.findByScore(enrollment.getTotalScore());
		LOG.debug("findByScore:{}", gradeCode.getCode());
		Assert.notNull(gradeCode, "gradeCode cannot be null");

		//Set GradeCode
		enrollment.setGradeCode(gradeCode);
		termService.updateEnrollment(enrollment);
		LOG.debug("gradeCode_IN_Enrollment_Table:{}",enrollment.getGradeCode().getCode());
		Assert.isTrue(enrollment.getGradeCode().equals(gradeCode), "gradeCode cannot be different");

		//CalculateGPA
//		plannerService.calculateGpa(admission);
		LOG.debug("GPA:{}", admission.getGpa());
		LOG.debug("CGPA:{}", admission.getCgpa());

		BigDecimal expectedGpa = new BigDecimal("2.00");
		BigDecimal actualGpa = admission.getGpa();
		Assert.isTrue(expectedGpa.equals(actualGpa), "Expected gpa " + expectedGpa + "found " + actualGpa);
		return self();
	}
	
	public WhenUpdateGradeBook update_gradeBook_Sem2() {
		Assert.notNull(assessment, "Assessment cannot be null");
		Assert.notNull(enrollment, "Enrollment cannot be null");
		Assert.notNull(section, "Section cannot be null");

		//Setup 2 gradebooks for each assessment
		createGradebookSem2("MASTER-MBA-GST5063-201720182-Q1");
		createGradebookSem2("MASTER-MBA-GST5063-201720182-Q2");

		termService.calculateGradebook(offering);
		LOG.debug("Enrollment_Total_Score:{}",enrollment.getTotalScore());
		
		AdGradeCode gradeCode = commonService.findByScore(enrollment.getTotalScore());
		LOG.debug("findByScore:{}", gradeCode.getCode());
		Assert.notNull(gradeCode, "gradeCode cannot be null");

		//Set GradeCode
		enrollment.setGradeCode(gradeCode);
		termService.updateEnrollment(enrollment);
		LOG.debug("gradeCode_IN_Enrollment_Table:{}",enrollment.getGradeCode().getCode());
		Assert.isTrue(enrollment.getGradeCode().equals(gradeCode), "gradeCode cannot be different");

		//CalculateGPA
//		plannerService.calculateGpa(admission);
		LOG.debug("GPA:{}", admission.getGpa());
		LOG.debug("CGPA:{}", admission.getCgpa());
//
//		BigDecimal expectedGpa = new BigDecimal("2.00");
//		BigDecimal actualGpa = admission.getGpa();
//		Assert.isTrue(expectedGpa.equals(actualGpa), "Expected gpa " + expectedGpa + "found " + actualGpa);
		return self();
	}

	private void createGradebook(String assessmentCode) {
		AdGradebook gradebook = new AdGradebookImpl();
		gradebook.setScore(new BigDecimal(BigInteger.valueOf(50)));
		gradebook.setAssessment(termService.findAssessmentByCanonicalCode(assessmentCode));
		gradebook.setEnrollment(enrollment);
		gradebook.setSection(section);
		termService.addGradebook(section, enrollment, gradebook);
		LOG.debug("gradebook Assessment:{}", gradebook.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook.getScore());
		Assert.notNull(gradebook, "gradebook cannot be null");
	}
	
	private void createGradebookSem2(String assessmentCode) {
		AdGradebook gradebook = new AdGradebookImpl();
		gradebook.setScore(new BigDecimal(BigInteger.valueOf(80)));
		gradebook.setAssessment(termService.findAssessmentByCanonicalCode(assessmentCode));
		gradebook.setEnrollment(enrollment);
		gradebook.setSection(section);
		termService.addGradebook(section, enrollment, gradebook);
		LOG.debug("gradebook Assessment:{}", gradebook.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook.getScore());
		Assert.notNull(gradebook, "gradebook cannot be null");
	}
}
