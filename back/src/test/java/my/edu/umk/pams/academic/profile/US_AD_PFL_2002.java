package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenCurrentStudentProfileInfoIsUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateStudentProfileInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to update student profile information so that student current personal information updated")
@Submodule("Profile")
@Issue("PAMA-10")
public class US_AD_PFL_2002 extends
        SpringScenarioTest<GivenIAmAdministrator, WhenIUpdateStudentProfileInfo, ThenCurrentStudentProfileInfoIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2002.class);

    @Test
    @Rollback
    public void scenarioCPS() {
    	String username  = "cps";
    	String password  = "abc123";
        given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().I_update_student_profile_info();
        then().current_student_profile_info_is_updated();

    }

    @Test
    @Rollback
    public void scenarioMGSEB() {
    	String username  = "mgseb";
    	String password  = "abc123";
        given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().I_update_student_profile_info();
        then().current_student_profile_info_is_updated();
    }

}
