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
	private AdOfferingDao offeringDao;

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

		//find program
		program = plannerService.findProgramByCode("A10");
		faculty = program.getFaculty();
	
		//add new offering		
		AdOffering offering = new AdOfferingImpl();
		offering.setCanonicalCode("A01/MASTER/1/DDA2113");
		offering.setCapacity(100);
		offering.setCode("DDA2113");
		offering.setTitle("Offering 1");
		offering.setProgram(program);
		termService.saveOffering(offering);
		
		LOG.debug("OFFERING SETUP ================================");
		LOG.debug("CanonicalCode :{}", offering.getCanonicalCode());
		LOG.debug("Capacity :{}", offering.getCapacity());
		LOG.debug("Code :{}", offering.getCode());
		LOG.debug("Title :{}", offering.getTitle());
		LOG.debug("Program :{}", offering.getProgram().getCode());
		
		//setup assessment
		AdAssessment assessment = new AdAssessmentImpl();
		assessment.setCanonicalCode("A01/MASTER/1/DDA2113");
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setCode("MASTER/1");
		assessment.setDescription("MECHANICS OF MATERIALS");
		assessment.setOffering(offering);
		assessment.setOrdinal(0);
		assessment.setSession(session);
		assessment.setTotalScore(BigDecimal.ZERO);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, assessment);
		
		LOG.debug("ASSESSMENT SETUP ================================");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		
		//assert
		Assert.notNull(assessment, "Assessments not setup");
		return self();
				
	}
	
	public WhenIAmSetupExamViva i_update_exam(){
		//find assessment by CanonicalCode
		assessment = termService.findAssessmentByCanonicalCode("A01/MASTER/1/DDA2113");
		
		//update assessment
		assessment.setCanonicalCode("A01/MASTER/2/DDA2113");
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setCode("MASTER/2");
		assessment.setDescription("MECHANICS OF MATERIALS");
		assessment.setOffering(offering);
		assessment.setOrdinal(0);
		assessment.setSession(session);
		assessment.setTotalScore(BigDecimal.ZERO);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setWeight(BigDecimal.ZERO);
		termService.updateAssessment(session, offering, assessment);
		
		LOG.debug("ASSESSMENT UPDATED ================================");
		LOG.debug("Assessment CanonicalCOde :{}", assessment.getCanonicalCode());
		LOG.debug("assessment Category :{}", assessment.getCategory().name());
		LOG.debug("assessment Code :{}", assessment.getCode());
		LOG.debug("Assessment Desc :{}", assessment.getDescription());
		LOG.debug("Assessment Type :{}", assessment.getType().name());
		LOG.debug("Assessment TotalScore :{}", assessment.getTotalScore().byteValueExact());
		
		//assert
		Assert.notNull(assessment, "Assessments not setup");
		
		return self();
	}
	

	

}
