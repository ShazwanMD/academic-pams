package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdEnrollment;


@JGivenStage
public class ThenTheEnrollmentIsCurrent extends Stage<ThenTheEnrollmentIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentIsCurrent.class);
	
	@ExpectedScenarioState
	private AdEnrollment enrollment;

	public ThenTheEnrollmentIsCurrent the_enrollment_info_is_current() {

		LOG.debug("enrollment {} ", enrollment.getStatus());

		Assert.notNull(enrollment, "Enrollment data should be inserted");

		return self();

	}
}
