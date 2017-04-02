package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIViewCourseInfomation extends Stage<WhenIViewCourseInfomation> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewCourseInfomation.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private List<AdCourse> course;

	@ExpectedScenarioState
	private String code;

	@ExpectedScenarioState
	private AdFaculty faculty;

	public WhenIViewCourseInfomation() {
		AdFaculty faculty = new AdFacultyImpl();
	}

	public WhenIViewCourseInfomation I_view_course_infomation_$(String facultyCode) {
		faculty = plannerService.findFacultyByCode(code);
		course = plannerService.findCourses(faculty);
		for (AdCourse course : course) {
			LOG.debug(course.getTitle());
		}
		return self();
	}

	}

