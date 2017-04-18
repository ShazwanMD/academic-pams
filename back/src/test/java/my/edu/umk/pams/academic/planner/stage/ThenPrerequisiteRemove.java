package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenPrerequisiteRemove extends Stage<ThenPrerequisiteRemove> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenPrerequisiteRemove.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdCoursePrerequisite prerequisite;

	public ThenPrerequisiteRemove prerequite_$_for_course_$_is_removed(String prereqCode, String courseCode) {
		//AdCourse course = plannerService.findCourseByCode(courseCode);

		//List<AdCoursePrerequisite> prerequisites = course.getPrerequisites();
		//Assert.notNull(prerequisites, "prerequisites has been deleted");
		
			LOG.debug("============view data=============");
	        LOG.debug("course code : {}", courseCode);
	        LOG.debug("prerequisite: {}", prereqCode);
	
		return self();
	}
}
