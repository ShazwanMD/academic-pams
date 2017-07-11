package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;

@JGivenStage
public class WhenIAmSetupExamViva extends Stage<WhenIAmSetupExamViva> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmSetupExamViva.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAssessment assessment;

	@ExpectedScenarioState
	private AdOffering offering;

	@ExpectedScenarioState
	private AdAcademicSession session;



	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdProgramLevel level;
	
	@ExpectedScenarioState
	private AdUser user;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdCourse course;
	
	@ExpectedScenarioState
	private AdSection section;
	
	@ExpectedScenarioState
	private AdGradeCode grade;
	
	@ExpectedScenarioState
	private static String staffNo;
	
	@ProvidedScenarioState
	private AdGradebook gradeBook;
	

	public WhenIAmSetupExamViva i_setup_assessments() {
		
		staff = identityService.findStaffByStaffNo(staffNo);
		LOG.debug("Staff Name :{}", staff.getName());
		LOG.debug("Staff Type :{}", staff.getStaffType().name());
		
		faculty = staff.getFaculty();
		LOG.debug("Staff Faculty :{}", faculty.getName());
		
		program = staff.getProgram();
		LOG.debug("Program :{}", program.getCode());
		
		course = plannerService.findCourseByCodeAndFaculty("GST5013", faculty);
		LOG.debug("Course Title :{}", course.getTitleEn());

		level = program.getLevel();
		LOG.debug("Program Level :{}", level.getCode());
				
		// setup assessment
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q1");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q1");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(10)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setOffering(offering);
		termService.addAssessment( offering, assessment);
		Assert.notNull(assessment, "quiz1 is null");
		//LOG Debug Quiz 1
		LOG.debug("QUIZ 1 :========>");
		LOG.debug("QUIZ 1 CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("QUIZ 1 Category :{}", assessment.getCategory().name());
		LOG.debug("QUIZ 1 Code :{}", assessment.getCode());
		LOG.debug("QUIZ 1 Desc :{}", assessment.getDescription());
		LOG.debug("QUIZ 1 Type :{}", assessment.getType().name());
		LOG.debug("QUIZ 1 TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "assessmentQ1 Quiz1 is not setup");

		// setup assessment2
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q2");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q2");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(1);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(90)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setOffering(offering);
		termService.addAssessment(offering, assessment);
		Assert.notNull(assessment, "quiz2 is null");
		//LOG Debug Quiz 2
		LOG.debug("QUIZ 2 :========>");
		LOG.debug("QUIZ 2 CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("QUIZ 2 Category :{}", assessment.getCategory().name());
		LOG.debug("QUIZ 2 Code :{}", assessment.getCode());
		LOG.debug("QUIZ 2 Desc :{}", assessment.getDescription());
		LOG.debug("QUIZ 2 Type :{}", assessment.getType().name());
		LOG.debug("QUIZ 2 TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz2 is not setup");

		/*// setup assessment3
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/T1");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/T1");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(10)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(50)));
		assessment.setType(AdAssessmentType.TEST);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "test1 is null");
		//LOG Debug Test 1
		LOG.debug("TEST 1 :========>");
		LOG.debug("TEST 1 CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("TEST 1 Category :{}", assessment.getCategory().name());
		LOG.debug("TEST 1 Code :{}", assessment.getCode());
		LOG.debug("TEST 1 Desc :{}", assessment.getDescription());
		LOG.debug("TEST 1 Type :{}", assessment.getType().name());
		LOG.debug("TEST 1 TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Test 1 is not setup");

		// setup assessment4
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q3");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q3");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(5)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(50)));
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "quiz3 is null");
		//LOG Debug Quiz 3
		LOG.debug("QUIZ 3 :========>");
		LOG.debug("QUIZ 3  CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("QUIZ 3  Category :{}", assessment.getCategory().name());
		LOG.debug("QUIZ 3  Code :{}", assessment.getCode());
		LOG.debug("QUIZ 3  Desc :{}", assessment.getDescription());
		LOG.debug("QUIZ 3  Type :{}", assessment.getType().name());
		LOG.debug("QUIZ 3  TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz3 is not setup");

		// setup assessment4
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q4");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q4");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(5)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(50)));
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "quiz4 is null");
		//LOG Debug Quiz 4
		LOG.debug("QUIZ 4 :========>");
		LOG.debug("QUIZ 4 CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("QUIZ 4 Category :{}", assessment.getCategory().name());
		LOG.debug("QUIZ 4 Code :{}", assessment.getCode());
		LOG.debug("QUIZ 4 Desc :{}", assessment.getDescription());
		LOG.debug("QUIZ 4 Type :{}", assessment.getType().name());
		LOG.debug("QUIZ 4 TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz4 is not setup");

		// setup assessment5
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/T2");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/T2");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(10)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(50)));
		assessment.setType(AdAssessmentType.TEST);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "test2 is null");
		// LOG Debug Test 2
		LOG.debug("TEST 2 :========>");
		LOG.debug("TEST 2 CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("TEST 2 Category :{}", assessment.getCategory().name());
		LOG.debug("TEST 2 Code :{}", assessment.getCode());
		LOG.debug("TEST 2 Desc :{}", assessment.getDescription());
		LOG.debug("TEST 2 Type :{}", assessment.getType().name());
		LOG.debug("TEST 2 TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Test 2 is not setup");

		// setup assessment6
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/FinalExam");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/FinalExam");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(new BigDecimal(BigInteger.valueOf(60)));
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(50)));
		assessment.setType(AdAssessmentType.FINAL_EXAM);
		assessment.setCategory(AdAssessmentCategory.EXAM_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "FinalExam is null");
		// LOG Debug FinalExam
		LOG.debug("FinalExam  :========>");
		LOG.debug("FinalExam CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("FinalExam Category :{}", assessment.getCategory().name());
		LOG.debug("FinalExam Code :{}", assessment.getCode());
		LOG.debug("FinalExam Desc :{}", assessment.getDescription());
		LOG.debug("FinalExam Type :{}", assessment.getType().name());
		LOG.debug("FinalExam TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("Weight :{}", assessment.getWeight().toBigInteger());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments FinalExam is not setup");
*/		
			return self();	
	}
}
		