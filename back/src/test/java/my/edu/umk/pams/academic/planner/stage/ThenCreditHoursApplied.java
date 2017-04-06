package my.edu.umk.pams.academic.planner.stage;

/*Given : I Am Admin
 * When : Admin Set Credit
 * Then :  Set Credit Has Introduced.
 * @author zaida
 */

import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import java.util.List;
import java.util.Objects;

@JGivenStage
public class ThenCreditHoursApplied extends Stage<ThenCreditHoursApplied> {

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@Autowired
	private PlannerService plannerService;

	private static final Logger LOG = LoggerFactory.getLogger(ThenCreditHoursApplied.class);

	public ThenCreditHoursApplied course_credit_hours_are_applied(Integer credit) {
		Integer expected = credit;
		Assert.notNull(faculty, "faculty cannot be null");

		List<AdCourse> courses = plannerService.findCourses(faculty);
		for (AdCourse course : courses) {
			Integer found = course.getCredit();
			String message = "expected " + expected + ", found " + found;
			Assert.isTrue(Objects.equals(found, credit), message);
		}

//		todo: incorporate academicSession seems appropriate
//		Assert.notNull(academicSession, "academicSession cannot be null");
//		LOG.debug("academicSession {} ", academicSession);

		// AdAcademicSession academicSession =
		// plannerService.findCurrentAcademicSession();

		return self();

	}

}
