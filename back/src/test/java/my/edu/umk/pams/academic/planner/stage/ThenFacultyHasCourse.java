package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author zaida_nawi
 **/
@JGivenStage
public class ThenFacultyHasCourse extends Stage<ThenFacultyHasCourse> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenFacultyHasCourse.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	AdFaculty faculty;

	@ExpectedScenarioState
	AdCourse course;

	public ThenFacultyHasCourse faculty_has_courses() {
		List<AdCourse> courses = plannerService.findCourses(faculty);
		Assert.notEmpty(courses, "courses cannot be empty");

		for (AdCourse course : courses) {
			LOG.debug("course : {}", course.getCode());
			Assert.notNull(course.getCode(), "course code should not be empty");
		}

		for (AdCourse course : courses) {
			LOG.debug("Faculty : {}", course.getFaculty());
			Assert.notNull(course.getFaculty(), "course Faculty should not be empty");
		}

		for (AdCourse course : courses) {
			LOG.debug("course : {}", course.getClassification().LEVEL_100);
			Assert.notNull(course.getClassification().LEVEL_100, "course Classification should not be empty");
		}

		for (AdCourse course : courses) {
			LOG.debug("course : {}", course.getTitle());
			Assert.notNull(course.getTitle(), "course Title should not be empty");
		}

		for (AdCourse course : courses) {
			LOG.debug("course : {}", course.getTitleEn());
			Assert.notNull(course.getTitleEn(), "course TitleEn should not be empty");
		}
		for (AdCourse course : courses) {
			LOG.debug("course : {}", course.getTitleMs());
			Assert.notNull(course.getTitleMs(), "course TitleMs should not be empty");
		}
		for (AdCourse course : courses) {
			LOG.debug("course : {}", course.getCredit());
			Assert.notNull(course.getCredit(), "course Credit should not be empty");
		}
		return self();
	}
}