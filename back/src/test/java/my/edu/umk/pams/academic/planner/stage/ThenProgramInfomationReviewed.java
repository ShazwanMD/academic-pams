package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThenProgramInfomationReviewed extends Stage<ThenProgramInfomationReviewed> {


    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String code;

    private boolean exists;

    @Pending
    public ThenProgramInfomationReviewed Program_Infomation_reviewed() {

        return self();
		
	}
}
