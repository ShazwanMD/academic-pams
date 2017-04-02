package my.edu.umk.pams.academic.planner.stage;
/**
 * @author zaida_ain
 */
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenProgramLevelReviewed extends Stage<ThenProgramLevelReviewed> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenProgramLevelReviewed.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    AdProgram Level;

    public ThenProgramLevelReviewed Program_level_introduced() {
        List<AdProgramLevel> programLevel = plannerService.findProgramLevels();
        Assert.notEmpty(programLevel, "programs should not be empty");
        return self();
    }
}
