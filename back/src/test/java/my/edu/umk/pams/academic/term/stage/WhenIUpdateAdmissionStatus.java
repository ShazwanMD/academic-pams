package my.edu.umk.pams.academic.term.stage;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIUpdateAdmissionStatus extends Stage<WhenIUpdateAdmissionStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAdmissionStatus.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStudyCenter studyCenter;
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	@ExpectedScenarioState
    private AdAcademicSession academicSession;

	public WhenIUpdateAdmissionStatus I_update_admission_status_for_program_$(String code) {

		student = identityService.findStudentByMatricNo("A17P002");
		program = plannerService.findProgramByCode("A01/MASTER/0002");
		
		LOG.debug("student: {}", student.getId());
		LOG.debug("program: {}", program.getId());
		LOG.debug("academicSession: {}", academicSession.getId());
				
		admission = termService.findAdmissionBySessionProgramAndStudent(academicSession, program, student);
		
		admission.setCgpa(new BigDecimal("3.80"));
		admission.setCreditEarned(110);
		admission.setCreditTaken(110);
		admission.setGpa(new BigDecimal("3.80"));
		admission.setProgram(program);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KS);
		admission.setStatus(AdAdmissionStatus.POSTPONED);
		admission.setStudent(student);
		admission.setStudyCenter(studyCenter);

		termService.updateAdmission(admission);

		return self();

	}
}
