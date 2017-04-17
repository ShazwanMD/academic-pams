package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIDeleteCoursePrerequisite extends Stage<WhenIDeleteCoursePrerequisite> {
	
	
	
	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	List<AdCoursePrerequisite> prerequisite;
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddCoursePrerequisite.class);

	public WhenIDeleteCoursePrerequisite Admin_delete_prereq_$_to_course_$(String prereqCode, String courseCode) {

		AdCourse course = plannerService.findCourseByCode(courseCode);
		LOG.debug(" course code: {}", course.getCode());
		
		AdCourse prereqCourse = plannerService.findCourseByCode(prereqCode);
		LOG.debug(" course prerequisite: {}", prereqCourse.getCode());
		
		course.setCode("GST5033");
		course.setPrerequisites(prerequisite);

		plannerService.delatePrerequisite(course, prereqCourse);

		return self();

	}

}
