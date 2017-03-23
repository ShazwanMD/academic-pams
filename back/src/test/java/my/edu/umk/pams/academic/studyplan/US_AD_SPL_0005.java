package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenGroupScheduleByIntakeCode;
import my.edu.umk.pams.academic.studyplan.stage.WhenIAdACohort;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
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

/**
 * As an admin academic,
 * i want to set up cohort for a faculty,
 * so that i can group student in the schedule by intake code.
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_SPL_0005 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAdACohort, ThenGroupScheduleByIntakeCode> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_0005.class);
    public static final String PROGRAM_CODE = "FIAT/PHD/0001";

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_CPS_administrator();
        when().I_want_to_set_up_cohort_for_$_program(PROGRAM_CODE);
        then().group_students_in_the_schedule_by_intake_code();
    }

}
