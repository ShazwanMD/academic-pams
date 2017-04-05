package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class ThenProgramLevelIntroduced extends Stage<ThenProgramLevelIntroduced> {

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdProgram program;
    
    @ExpectedScenarioState
    private String PROGRAM_CODE;
    
    @ExpectedScenarioState
    private String FACULTY_CODE;


    public ThenProgramLevelIntroduced program_level_$_introduced(String PROGRAM_CODE) {

//        List<AdProgramLevel> ProgramLevels = plannerService.findProgramLevels();
       // Assert.notEmpty(ProgramLevels);

        return self();
    }
}
