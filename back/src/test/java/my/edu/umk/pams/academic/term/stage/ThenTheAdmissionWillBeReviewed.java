package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheAdmissionWillBeReviewed extends Stage<ThenTheAdmissionWillBeReviewed> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionWillBeReviewed.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdStaff advisor;

	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdStudyCenter studyCenter;
	
	@ExpectedScenarioState
	private AdStudyCenterCode studyCenterCode;

	public ThenTheAdmissionWillBeReviewed The_admission_will_be_reviewed() {

		LOG.debug("Admission for new student: {}", student.getName());
		LOG.debug("Advisor: {}", advisor.getName());
		LOG.debug("Program: {}", program.getTitle());
		LOG.debug("studyCenter {}", studyCenterCode.getDescription());

		return self();

	}

}
