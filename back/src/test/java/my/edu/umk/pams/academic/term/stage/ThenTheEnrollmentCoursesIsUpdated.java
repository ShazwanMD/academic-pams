package my.edu.umk.pams.academic.term.stage;

/* @author asyikin.mr and ziana
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import my.edu.umk.pams.academic.term.model.AdEnrollment;

public class ThenTheEnrollmentCoursesIsUpdated extends Stage<ThenTheEnrollmentCoursesIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentCoursesIsUpdated.class);

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	public ThenTheEnrollmentCoursesIsUpdated the_enrollment_courses_is_updated() {

		LOG.debug("Enrollment for repeated course is {} ", enrollment.getStatus());
		Assert.notNull(enrollment, "Enrollment data should be inserted");

		return self();
	}
}