package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenCanTakeInNewSemester extends Stage<ThenCanTakeInNewSemester> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenCanTakeInNewSemester.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    AdFaculty faculty;

    public ThenCanTakeInNewSemester Can_take_in_new_semester() {
        List<AdProgram> programs = studyplanService.findPrograms(faculty);
        Assert.notEmpty(programs, "programs should not be empty");
        return self();
    }
}
