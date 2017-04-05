package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenProgramInfoIsUpdated extends Stage<ThenProgramInfoIsUpdated> {

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    AdFaculty faculty;

    public ThenProgramInfoIsUpdated the_program_is_current_for_$(String facultyCode) {

        boolean exists = plannerService.isProgramExists("A01", faculty);
        Assert.isTrue(exists, "cool");

        return self();
    }
}
