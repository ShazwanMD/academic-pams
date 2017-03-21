package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThenICanManageScheduleByProgram extends Stage<ThenICanManageScheduleByProgram> {

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String code;

    private boolean exists;

    @Pending
    public ThenICanManageScheduleByProgram I_can_manage_schedule_by_program() {

        return self();
    }

}
