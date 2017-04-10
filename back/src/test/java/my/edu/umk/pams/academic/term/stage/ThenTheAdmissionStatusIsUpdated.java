package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheAdmissionStatusIsUpdated extends Stage<ThenTheAdmissionStatusIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionStatusIsUpdated.class);

	@Autowired
	private TermService termService;
	
	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	private AdAdmission admission;
	
	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
    private AdAcademicSession academicSession;

	public ThenTheAdmissionStatusIsUpdated the_admission_status_is_updated() {

		AdStudent student = identityService.findStudentByMatricNo("A17P001");
		AdProgram program = plannerService.findProgramByCode("A01/MASTER/0001");
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode("201720181");
		
		LOG.debug("student: {}", student.getId());
		LOG.debug("program: {}", program.getId());
		LOG.debug("academicSession: {}", academicSession.getId());
		
		AdAdmission admission = termService.findAdmissionBySessionProgramAndStudent(academicSession, program, student);
			
		LOG.debug("Admission status info is updated: {} ", admission.getStatus());
		LOG.debug("Admission academic standing info is updated: {} ", admission.getStanding());
		
		Assert.notNull(admission, "Admission data should be updated");

		return self();
	}
}