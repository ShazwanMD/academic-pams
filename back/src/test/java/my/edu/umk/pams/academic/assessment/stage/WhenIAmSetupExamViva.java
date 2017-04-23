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

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.dao.AdOfferingDao;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdAssessmentCategory;
import my.edu.umk.pams.academic.term.model.AdAssessmentImpl;
import my.edu.umk.pams.academic.term.model.AdAssessmentType;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
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
	private AdOffering offer;

	@ProvidedScenarioState
	private AdAcademicSession session;



	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdProgramLevel level;
	
	@ExpectedScenarioState
	private AdUser user;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	private AdSection section;
	
	@ProvidedScenarioState
	private AdGradeCode grade;
	
	@ExpectedScenarioState
	private static String staffNo;
	

	public WhenIAmSetupExamViva i_setup_assessments() {
		
		staff = identityService.findStaffByStaffNo(staffNo);
		LOG.debug("Staff Name :{}", staff.getName());
		LOG.debug("Staff Type :{}", staff.getStaffType().name());
		
		faculty = staff.getFaculty();
		LOG.debug("Staff Faculty :{}", faculty.getName());
		
		program = staff.getProgram();
		LOG.debug("Program :{}", program.getCode());
		
		course = plannerService.findCourseByCodeAndFaculty("GST5013", faculty);
		LOG.debug("Course Title :{}", course.getTitle());

		level = program.getProgramLevel();
		LOG.debug("Program Level :{}", level.getCode());
		

		offer = new AdOfferingImpl();
		offer.setCanonicalCode("MASTER/MBA/GST5013/201720181");
		offer.setCode("MASTER/MBA/GST5013");
		offer.setTitle("Economics & Business Environment");
		offer.setCapacity(100);
		offer.setProgram(program);
		offer.setCourse(course);
		offer.getSections();
		termService.saveOffering(offer);
		
		section = new AdSectionImpl();
		section.setCode("Section A");
		section.setCanonicalCode("MASTER/MBA/GST5013/201720181/Section A");
		section.setOrdinal(1);
		section.setCapacity(20);
		section.setSession(session);
		section.setOffering(offer);
		termService.saveSection(section);
		
		
		// setup assessment
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q1");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q1");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(BigDecimal.TEN);
		assessment.setTotalScore(BigDecimal.TEN);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "quiz1 is null");
		//LOG Debug Quiz 1
		LOG.debug("QUIZ 1 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz1 is not setup");

		// setup assessment2
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q2");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q2");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(BigDecimal.TEN);
		assessment.setTotalScore(BigDecimal.TEN);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "quiz2 is null");
		//LOG Debug Quiz 2
		LOG.debug("QUIZ 2 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz2 is not setup");

		// setup assessment3
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/T1");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/T1");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(BigDecimal.TEN);
		assessment.setTotalScore(BigDecimal.TEN);
		assessment.setType(AdAssessmentType.TEST);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "test1 is null");
		//LOG Debug Test 1
		LOG.debug("TEST 1 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Test 1 is not setup");

		// setup assessment4
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q3");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q3");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(BigDecimal.TEN);
		assessment.setTotalScore(BigDecimal.TEN);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "quiz3 is null");
		//LOG Debug Quiz 3
		LOG.debug("QUIZ 3 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz3 is not setup");

		// setup assessment4
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/Q4");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q4");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(BigDecimal.TEN);
		assessment.setTotalScore(BigDecimal.TEN);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "quiz4 is null");
		//LOG Debug Quiz 4
		LOG.debug("QUIZ 4 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Quiz4 is not setup");

		// setup assessment5
		assessment = new AdAssessmentImpl();
		assessment.setCode("MASTER/MBA/GST5013/T2");
		assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/T2");
		assessment.setDescription("Economics & Business Environment");
		assessment.setOrdinal(0);
		assessment.setWeight(BigDecimal.TEN);
		assessment.setTotalScore(BigDecimal.TEN);
		assessment.setType(AdAssessmentType.TEST);
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setSession(session);
		assessment.setOffering(offer);
		termService.addAssessment(session, offer, assessment);
		Assert.notNull(assessment, "test2 is null");
		//LOG Debug Test 2
		LOG.debug("TEST 2 :========>");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		LOG.debug("");
		// assert
		Assert.notNull(assessment, "Assessments Test 2 is not setup");
		return self();

	}

	

}
		