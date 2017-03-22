package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramLevel;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class ThenProgramLevelIntroduced extends Stage<ThenProgramLevelIntroduced> {

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdProgram program;


    public ThenProgramLevelIntroduced program_level_$_introduced(String PROGRAM_CODE) {

        List<AdProgramLevel> ProgramLevels = studyplanService.findProgramLevels();
        Assert.notEmpty(ProgramLevels);

        return self();
    }
}
