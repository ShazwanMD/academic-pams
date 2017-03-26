package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;


@JGivenStage
public class ThenGroupScheduleByIntakeCode extends Stage<ThenGroupScheduleByIntakeCode> {

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdProgram program;

    public ThenGroupScheduleByIntakeCode group_students_in_the_schedule_by_intake_code() {
        List<AdCohort> cohort = plannerService.findCohorts(program, 0, 100);
        Assert.notEmpty(cohort, "Cohort should not be empty");
        return self();
    }
}
