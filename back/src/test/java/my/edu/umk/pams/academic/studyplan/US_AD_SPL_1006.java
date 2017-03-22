package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenICanManageScheduleByProgram;
import my.edu.umk.pams.academic.studyplan.stage.WhenIWantToSetUpCurriculumForAFaculty;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*
 * As an admin academic, 
 * i want to set up curriculum for a faculty, 
 * so that i can manage schedule by program.
 * @author zaida
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_SPL_1006 extends SpringScenarioTest<GivenIAmAdministrator, WhenIWantToSetUpCurriculumForAFaculty, ThenICanManageScheduleByProgram> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_1006.class);

    private static final String FACULTY_CODE = "FKP";

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1006() {
        given().I_am_a_PPS_administrator_in_current_academic_session();
        when().I_want_to_set_up_curriculum_for_a_faculty_$(FACULTY_CODE);
        then().I_can_manage_schedule_by_program();
    }
}

	