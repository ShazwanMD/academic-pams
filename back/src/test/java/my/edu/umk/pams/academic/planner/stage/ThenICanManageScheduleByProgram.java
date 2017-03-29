package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThenICanManageScheduleByProgram extends Stage<ThenICanManageScheduleByProgram> {

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdProgram program;

	@Pending
	public ThenICanManageScheduleByProgram I_can_manage_schedule_by_program() {
		boolean exists = plannerService.isCurriculumExists(program.getCode() + "/CRLM/0002");
		Assert.isTrue(exists, "Program does not have curriculum");
		return self();
	}

}
