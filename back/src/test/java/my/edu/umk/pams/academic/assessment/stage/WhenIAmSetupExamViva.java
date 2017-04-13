package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.dao.AdOfferingDao;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdAssessmentCategory;
import my.edu.umk.pams.academic.term.model.AdAssessmentImpl;
import my.edu.umk.pams.academic.term.model.AdAssessmentType;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.service.TermService;

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

	@ProvidedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdAcademicSession session;



	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdUser user;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdCourse course;

	public WhenIAmSetupExamViva i_setup_exam() {

		// find program
		program = plannerService.findProgramByCode("A10");
		faculty = program.getFaculty();

		// add new offering
		offering = new AdOfferingImpl();
		offering.setCanonicalCode("A01/MASTER/1/DDA2113");
		offering.setCapacity(100);
		offering.setCode("DDA2113");
		offering.setTitle("Offering 1");
		offering.setProgram(program);
		termService.saveOffering(offering);
		Assert.notNull(offering, "offering is null");

		// setup assessment
		AdAssessment quiz1 = new AdAssessmentImpl();
		quiz1.setCanonicalCode("A01/MASTER/Q1/DDA2113");
		quiz1.setCategory(AdAssessmentCategory.COURSE_WORK);
		quiz1.setCode("MASTER/Q1");
		quiz1.setDescription("MECHANICS OF MATERIALS");
		quiz1.setOffering(offering);
		quiz1.setOrdinal(0);
		quiz1.setSession(session);
		quiz1.setTotalScore(BigDecimal.ZERO);
		quiz1.setType(AdAssessmentType.QUIZ);
		quiz1.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, quiz1);
		Assert.notNull(quiz1, "quiz1 is null");

		LOG.debug("QUIZ 1 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", quiz1.getCanonicalCode());
		LOG.debug("assessment Category :{}", quiz1.getCategory().name());
		LOG.debug("assessment Code :{}", quiz1.getCode());
		LOG.debug("Assessment Desc :{}", quiz1.getDescription());
		LOG.debug("Assessment Type :{}", quiz1.getType().name());
		LOG.debug("Assessment TotalScore :{}", quiz1.getTotalScore().byteValueExact());
		// assert
		Assert.notNull(quiz1, "Assessments not setup");

		// setup assessment2
		AdAssessment quiz2 = new AdAssessmentImpl();
		quiz2.setCanonicalCode("A01/MASTER/Q2/DDA2113");
		quiz2.setCategory(AdAssessmentCategory.COURSE_WORK);
		quiz2.setCode("MASTER/Q2");
		quiz2.setDescription("MECHANICS OF MATERIALS");
		quiz2.setOffering(offering);
		quiz2.setOrdinal(0);
		quiz2.setSession(session);
		quiz2.setTotalScore(BigDecimal.ZERO);
		quiz2.setType(AdAssessmentType.QUIZ);
		quiz2.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, quiz2);
		Assert.notNull(quiz2, "quiz2 is null");

		LOG.debug("QUIZ 2 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", quiz2.getCanonicalCode());
		LOG.debug("assessment Category :{}", quiz2.getCategory().name());
		LOG.debug("assessment Code :{}", quiz2.getCode());
		LOG.debug("Assessment Desc :{}", quiz2.getDescription());
		LOG.debug("Assessment Type :{}", quiz2.getType().name());
		LOG.debug("Assessment TotalScore :{}", quiz2.getTotalScore().byteValueExact());

		// setup assessment3
		AdAssessment test1 = new AdAssessmentImpl();
		test1.setCanonicalCode("A01/MASTER/T1/DDA2113");
		test1.setCategory(AdAssessmentCategory.COURSE_WORK);
		test1.setCode("MASTER/T1");
		test1.setDescription("MECHANICS OF MATERIALS");
		test1.setOffering(offering);
		test1.setOrdinal(0);
		test1.setSession(session);
		test1.setTotalScore(BigDecimal.ZERO);
		test1.setType(AdAssessmentType.TEST);
		test1.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, test1);
		Assert.notNull(test1, "test1 is null");

		LOG.debug("TEST 1 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", test1.getCanonicalCode());
		LOG.debug("assessment Category :{}", test1.getCategory().name());
		LOG.debug("assessment Code :{}", test1.getCode());
		LOG.debug("Assessment Desc :{}", test1.getDescription());
		LOG.debug("Assessment Type :{}", test1.getType().name());
		LOG.debug("Assessment TotalScore :{}", test1.getTotalScore().byteValueExact());

		// setup assessment4
		AdAssessment quiz3 = new AdAssessmentImpl();
		quiz3.setCanonicalCode("A01/MASTER/Q3/DDA2113");
		quiz3.setCategory(AdAssessmentCategory.COURSE_WORK);
		quiz3.setCode("MASTER/Q3");
		quiz3.setDescription("MECHANICS OF MATERIALS");
		quiz3.setOffering(offering);
		quiz3.setOrdinal(0);
		quiz3.setSession(session);
		quiz3.setTotalScore(BigDecimal.ZERO);
		quiz3.setType(AdAssessmentType.QUIZ);
		quiz3.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, quiz3);
		Assert.notNull(quiz3, "quiz3 is null");

		LOG.debug("QUIZ 3 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", quiz3.getCanonicalCode());
		LOG.debug("assessment Category :{}", quiz3.getCategory().name());
		LOG.debug("assessment Code :{}", quiz3.getCode());
		LOG.debug("Assessment Desc :{}", quiz3.getDescription());
		LOG.debug("Assessment Type :{}", quiz3.getType().name());
		LOG.debug("Assessment TotalScore :{}", quiz3.getTotalScore().byteValueExact());

		// setup assessment4
		AdAssessment quiz4 = new AdAssessmentImpl();
		quiz4.setCanonicalCode("A01/MASTER/Q4/DDA2113");
		quiz4.setCategory(AdAssessmentCategory.COURSE_WORK);
		quiz4.setCode("MASTER/Q4");
		quiz4.setDescription("MECHANICS OF MATERIALS");
		quiz4.setOffering(offering);
		quiz4.setOrdinal(0);
		quiz4.setSession(session);
		quiz4.setTotalScore(BigDecimal.ZERO);
		quiz4.setType(AdAssessmentType.QUIZ);
		quiz4.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, quiz4);
		Assert.notNull(quiz4, "quiz4 is null");

		LOG.debug("QUIZ 4 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", quiz4.getCanonicalCode());
		LOG.debug("assessment Category :{}", quiz4.getCategory().name());
		LOG.debug("assessment Code :{}", quiz4.getCode());
		LOG.debug("Assessment Desc :{}", quiz4.getDescription());
		LOG.debug("Assessment Type :{}", quiz4.getType().name());
		LOG.debug("Assessment TotalScore :{}", quiz4.getTotalScore().byteValueExact());

		// setup assessment5
		AdAssessment test2 = new AdAssessmentImpl();
		test2.setCanonicalCode("A01/MASTER/T2/DDA2113");
		test2.setCategory(AdAssessmentCategory.COURSE_WORK);
		test2.setCode("MASTER/T2");
		test2.setDescription("MECHANICS OF MATERIALS");
		test2.setOffering(offering);
		test2.setOrdinal(0);
		test2.setSession(session);
		test2.setTotalScore(BigDecimal.ZERO);
		test2.setType(AdAssessmentType.TEST);
		test2.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, test2);
		Assert.notNull(test2, "test2 is null");

		LOG.debug("TEST 2 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", test2.getCanonicalCode());
		LOG.debug("assessment Category :{}", test2.getCategory().name());
		LOG.debug("assessment Code :{}", test2.getCode());
		LOG.debug("Assessment Desc :{}", test2.getDescription());
		LOG.debug("Assessment Type :{}", test2.getType().name());
		LOG.debug("Assessment TotalScore :{}", test2.getTotalScore().byteValueExact());

		return self();

	}

	public WhenIAmSetupExamViva i_update_exam() {
		// find assessment by CanonicalCode
		assessment = termService.findAssessmentByCanonicalCode("A01/MASTER/Q1/DDA2113");
		Assert.notNull(assessment, "assessment is null");

		// update assessment (quiz 1 == quiz 1.1)
		assessment.setCanonicalCode("A01/MASTER/Q1.1/DDA2113");
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setCode("MASTER/Q1.1");
		assessment.setDescription("MECHANICS OF MATERIALS");
		assessment.setOffering(offering);
		assessment.setOrdinal(0);
		assessment.setSession(session);
		assessment.setTotalScore(BigDecimal.ZERO);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setWeight(BigDecimal.ZERO);

		termService.updateAssessment(session, offering, assessment);
		Assert.notNull(termService.findAssessmentByCanonicalCode("A01/MASTER/Q1.1/DDA2113"),
				"canonical code for assessment is not updated");

		LOG.debug("QUIZ 1 UPDATED ==========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());

		return self();
	}

}
