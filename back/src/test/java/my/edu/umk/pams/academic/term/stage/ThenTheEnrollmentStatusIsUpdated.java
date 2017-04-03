package my.edu.umk.pams.academic.term.stage;
/**
 * @author asyikin.mr and ziana
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheEnrollmentStatusIsUpdated extends Stage<ThenTheEnrollmentStatusIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentStatusIsUpdated.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdSection section;

	public ThenTheEnrollmentStatusIsUpdated the_enrollment_status_is_updated() {

		AdEnrollment enrollment = termService.findEnrollmentBySectionAndStudent(section, student);
		LOG.debug("Status enrollment has been updated: {}", enrollment.getStatus());
		LOG.debug("Student {}", student);
		LOG.debug("Section {}", section);

		return self();
	}
}