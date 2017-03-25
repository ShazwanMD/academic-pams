package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenICanManageScheduleDetail;
import my.edu.umk.pams.academic.studyplan.stage.WhenIWantToViewProgramByFaculty;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As a student, i want to view the course for my program so that I can plan
 * what to manage schedule detail.
 *
 * @author ain
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_SPL_2002
        extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewProgramByFaculty, ThenICanManageScheduleDetail> {

    private static final String FACULTY_CODE = "FKP";

    @Test
    @Rollback
    public void scenari2002() {
        given().I_am_a_student_in_current_academic_session();
        when().I_want_to_view_program_by_faculty_$(FACULTY_CODE);
        then().I_can_manage_schedule_detail();
    }
}