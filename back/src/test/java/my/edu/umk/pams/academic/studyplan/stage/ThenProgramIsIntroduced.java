package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenProgramIsIntroduced extends Stage<ThenProgramIsIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenProgramIsIntroduced.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    AdFaculty faculty;

    // todo(uda): better ways to assert
    public ThenProgramIsIntroduced program_is_introduced(){
        List<AdProgram> programs = studyplanService.findPrograms(faculty);
        Assert.assertTrue(!(programs.isEmpty()));
        return self();
    }
}
