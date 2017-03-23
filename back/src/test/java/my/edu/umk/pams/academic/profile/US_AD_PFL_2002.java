package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenCurrentStudentProfileInfoIsUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateStudentProfileInfo;
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

/*As an CPS/MGSEB admin,
        I want to update student profile info,
		so that I can know current student profile info is updated.
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_2002 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateStudentProfileInfo, ThenCurrentStudentProfileInfoIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2002.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario01() {
        given().I_am_a_CPS_administrator_in_current_academic_session();
        when().I_update_student_profile_info();
        then().current_student_profile_info_is_updated();

    }

}
