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
public class ThenProgramDetailReviewed extends Stage<ThenProgramDetailReviewed> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenProgramDetailReviewed.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private List<AdProgram> programs;

    public ThenProgramDetailReviewed Program_details_reviewed() {
//        boolean exists = plannerService.isProgramExists("A07/PHD/0001", faculty);
//        Assert.notEmpty(programs, "program should not be empty");
        
        return self();
    }
}
