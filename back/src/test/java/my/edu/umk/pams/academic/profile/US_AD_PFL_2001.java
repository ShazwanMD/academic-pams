package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenCurrentStudentProfileUpdate;
import my.edu.umk.pams.academic.profile.stage.WhenIAddStudentProfile;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
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
@As("As an academic administrator, I want to add student profile information so that student profile is updated")
public class US_AD_PFL_2001 extends SpringScenarioTest<GivenIAmAdministrator, WhenIAddStudentProfile, ThenCurrentStudentProfileUpdate> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2001.class);


    @Test
    @Rollback
    public void scenarioCPS() {
    	String username  = "cps";
    	String password  = "abc123";
        given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().I_add_student_profile();
        then().Current_student_profile_is_updated();
    }
    
    @Test
    @Rollback
    public void scenarioMGSEB() {
    	String username  = "mgseb";
    	String password  = "abc123";
        given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().I_add_student_profile();
        then().Current_student_profile_is_updated();
    }
}

