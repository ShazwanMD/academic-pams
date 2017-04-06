package my.edu.umk.pams.academic.planner.stage;

/*Given : I Am Admin
 * When : Admin Set Credit
 * Then :  Set Credit Has Introduced.
 * @author zaida
 */

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import java.util.List;

@JGivenStage
public class WhenEnterCreditHours extends Stage<WhenEnterCreditHours> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenEnterCreditHours.class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdFaculty faculty;

	public WhenEnterCreditHours I_set_course_credit_hours(Integer credit) {
		Assert.notNull(faculty, "faculty cannot be null");

		List<AdCourse> courses = plannerService.findCourses(faculty);
		courses.forEach(course -> {
			course.setCredit(credit);
			plannerService.updateCourse(faculty, course);
		});

		return self();

	}
}