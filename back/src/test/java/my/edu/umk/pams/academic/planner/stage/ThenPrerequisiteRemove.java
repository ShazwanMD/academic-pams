package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;

@JGivenStage
public class ThenPrerequisiteRemove extends Stage<ThenPrerequisiteRemove> {
	
	@ExpectedScenarioState
	List<AdCoursePrerequisite> prerequisite;

	public ThenPrerequisiteRemove prerequite_$_for_course_$_is_removed(String prereqCode, String courseCode) {

		//	todo (ain) The assertion(s)

		return self();
	}
}
