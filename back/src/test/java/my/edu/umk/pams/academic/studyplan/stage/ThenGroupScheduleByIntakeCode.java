package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;


@JGivenStage
public class ThenGroupScheduleByIntakeCode extends Stage<ThenGroupScheduleByIntakeCode> {

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    private AdProgram program;

    public ThenGroupScheduleByIntakeCode group_students_in_the_schedule_by_intake_code() {
        List<AdCohort> cohort = studyplanService.findCohorts(program, 0, 100);
        Assert.notEmpty(cohort, "Cohort should not be empty");
        return self();
    }
}
