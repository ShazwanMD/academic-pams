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
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheAdmissionWillBeReviewed extends Stage<ThenTheAdmissionWillBeReviewed> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionWillBeReviewed.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private TermService termService;


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
	
	@ExpectedScenarioState
	private AdAdmissionApplication admissionApplication;

	public ThenTheAdmissionWillBeReviewed The_admission_will_be_reviewed() {
		
		AdAdmissionApplication admissionApplication = termService.findAdmissionApplicationByProgramAndStudent(program, student);

		LOG.debug("Admission id for new student: {}", admissionApplication.getId());
		LOG.debug("Admission desc for new student: {}", admissionApplication.getDescription());
		LOG.debug("Admission audit no for new student: {}", admissionApplication.getAuditNo());
		
		LOG.debug("advisor {}", advisor.getName());
		LOG.debug("program {}", program.getTitle());
		LOG.debug("studyCenter {}", studyCenterCode.getDescription());

		return self();

	}

}
