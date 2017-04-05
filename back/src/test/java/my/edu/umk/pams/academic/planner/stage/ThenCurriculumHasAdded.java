package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThenCurriculumHasAdded extends Stage<ThenCurriculumHasAdded> {

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private AdCourse course;
	
	
	

	@Pending
	public ThenCurriculumHasAdded Curriculum_has_added() {
		boolean exists = plannerService.isCurriculumExists(faculty.getCode() + "/CRLM/0002");
		Assert.isTrue(exists, "faculty does not have curriculum");
		return self();
	}

}
