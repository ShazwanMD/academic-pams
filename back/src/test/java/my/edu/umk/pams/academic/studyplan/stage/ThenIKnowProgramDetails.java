package my.edu.umk.pams.academic.studyplan.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;


@JGivenStage
public class ThenIKnowProgramDetails extends Stage<ThenIKnowProgramDetails> {

    @Autowired
    private StudyplanService studyplanService;


    @ExpectedScenarioState
    private AdFaculty faculty;


    @ExpectedScenarioState
    private List<AdProgram> program;

    public ThenIKnowProgramDetails I_know_program_details() {
        boolean exists = studyplanService.isProgramExists("FIAT/PHD/0001", faculty);

        Assert.notEmpty(program, "program should not be empty");
        
        //Assert.isTrue(exists, "exists");
        return self();
    }


}
