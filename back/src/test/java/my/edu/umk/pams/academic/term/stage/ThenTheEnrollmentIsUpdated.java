package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdEnrollment;

@JGivenStage
public class ThenTheEnrollmentIsUpdated extends Stage<ThenTheEnrollmentIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentIsUpdated.class);

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	public ThenTheEnrollmentIsUpdated the_enrollment_is_updated() {

		Assert.notNull(enrollment, "Enrollment data should be not null");

		LOG.debug("New enrollment has been transfered: {} ", enrollment.getId());
		LOG.debug("New enrollment has been transfered: {} ", enrollment.getStanding());
		LOG.debug("New enrollment has been transfered: {} ", enrollment.getSection().getCanonicalCode());

		return null;

	}
}
