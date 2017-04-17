package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;

public class ThenCoursePrerequisiteDeleted {
	
	@ExpectedScenarioState
	List<AdCoursePrerequisite> prerequisite;

	@Pending
	public void course_$_is_a_prereq_for_course_$_deleted(String prereqCode, String courseCode) {
		
	}
}
