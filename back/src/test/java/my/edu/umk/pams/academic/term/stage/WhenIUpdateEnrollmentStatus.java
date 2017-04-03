package my.edu.umk.pams.academic.term.stage;
/**
 * @author asyikin.mr and ziana
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIUpdateEnrollmentStatus extends Stage<WhenIUpdateEnrollmentStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateEnrollmentStatus.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	public WhenIUpdateEnrollmentStatus I_update_enrollment_status_for_program_$(String code) {

		student = identityService.findStudentByStudentNo("A17P002");
		section = termService.findSectionByCanonicalCode("FKP/PHD/0001/DDA2113/201720181");
		enrollment = termService.findEnrollmentBySectionAndStudent(section, student);
		
		LOG.debug("Student:{}", student.getIdentityNo());
		LOG.debug("Section:{}", section.getCanonicalCode());
		LOG.debug("Enrollment status:{}", enrollment.getStatus());

		enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
		termService.updateEnrollment(enrollment);

		return self();
	}
}
