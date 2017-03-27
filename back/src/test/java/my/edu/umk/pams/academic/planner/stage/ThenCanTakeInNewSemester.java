package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenCanTakeInNewSemester extends Stage<ThenCanTakeInNewSemester> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenCanTakeInNewSemester.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    AdFaculty faculty;

    public ThenCanTakeInNewSemester Can_take_in_new_semester() {
        List<AdProgram> programs = plannerService.findPrograms(faculty);
        Assert.notEmpty(programs, "programs should not be empty");
        return self();
    }
}
