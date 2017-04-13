package my.edu.umk.pams.academic.assessment.stage;

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
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.dao.AdOfferingDao;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenExamVivaSetup extends Stage<ThenExamVivaSetup> {

private static final Logger LOG = LoggerFactory.getLogger(ThenExamVivaSetup.class);
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAssessment assessment;

	@ExpectedScenarioState
	private AdOffering offering;

	@ExpectedScenarioState
	private AdAcademicSession session;

	@ExpectedScenarioState
	private AdOfferingDao offeringDao;

	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdUser user;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdCourse course;
	
	public ThenExamVivaSetup exam_setup() {
		
	 boolean exists = termService.isAssessmentExists("A01/MASTER/Q1.1/DDA2113");
	 Assert.isTrue(exists, "Not Setup");
	 
	 boolean exists1 = termService.isAssessmentExists("A01/MASTER/Q2/DDA2113");
	 Assert.isTrue(exists1, "Not Setup");
	 
	 boolean exists2 = termService.isAssessmentExists("A01/MASTER/Q3/DDA2113");
	 Assert.isTrue(exists2, "Not Setup");
	 
	 boolean exists3 = termService.isAssessmentExists("A01/MASTER/T1/DDA2113");
	 Assert.isTrue(exists3, "Not Setup");
	 
	 boolean exists4 = termService.isAssessmentExists("A01/MASTER/Q3/DDA2113");
	 Assert.isTrue(exists4, "Not Setup");
	 
	 boolean exists5 = termService.isAssessmentExists("A01/MASTER/Q4/DDA2113");
	 Assert.isTrue(exists5, "Not Setup");
	 
	 boolean exists6 = termService.isAssessmentExists("A01/MASTER/T2/DDA2113");
	 Assert.isTrue(exists6, "Not Setup");
	 
	 
		
		return self();
		
	}

}
