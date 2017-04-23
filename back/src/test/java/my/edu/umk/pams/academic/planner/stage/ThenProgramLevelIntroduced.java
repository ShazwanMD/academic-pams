package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.model.AdProgramType;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class ThenProgramLevelIntroduced extends Stage<ThenProgramLevelIntroduced> {

	  private static final Logger LOG = LoggerFactory.getLogger(ThenProgramInfomationReviewed.class);
		
    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdProgramType programType;

    @ExpectedScenarioState
    private String PROGRAM_LEVEL_CODE = "POSTGRAD";

    public ThenProgramLevelIntroduced program_level_post_graduate_introduced() {
        AdProgramLevel programLevel = plannerService.findProgramLevelByCode(PROGRAM_LEVEL_CODE);
        Assert.notNull(programLevel, "programLevel cannot be null");

        Object[] argArray = {programLevel.getCode(), programLevel.getType(), programLevel.getDescription()};
        LOG.debug("program level code : {} {} {}", argArray);

        AdProgramType expected = programType;
        String message = "programLevel must be " + expected;
        Assert.isTrue(expected.equals(programLevel.getType()) , message);

        return self();
    }
}
