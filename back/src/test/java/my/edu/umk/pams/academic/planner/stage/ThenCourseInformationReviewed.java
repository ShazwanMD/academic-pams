package my.edu.umk.pams.academic.planner.stage;

/**
 * I Am Student
 * I Review Course Info
 * Course Information Reviewed
 * @author zaida
 */
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenCourseInformationReviewed extends Stage<ThenCourseInformationReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenCourseInformationReviewed.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	AdCourse course;

	@ExpectedScenarioState
	AdFaculty faculty;

	public ThenCourseInformationReviewed course_information_reviewed() {

		boolean exists = plannerService.isCourseExists("GST5013", faculty);

		Assert.isTrue(exists, "exists");

		return self();
	}
}
