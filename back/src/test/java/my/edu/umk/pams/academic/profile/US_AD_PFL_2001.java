package my.edu.umk.pams.academic.profile;

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

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenCurrentStudentProfileUpdate;
import my.edu.umk.pams.academic.profile.stage.WhenIAddStudentProfile;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_2001 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIAddStudentProfile, ThenCurrentStudentProfileUpdate> {

	   private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2001.class);


	    @Before
	    public void before() {
	    }

	    @After
	    public void after() {
	    }

	    @Test
	    @Rollback(false)
	    public void scenario1() {
	        given().I_am_a_PPS_administrator_in_current_academic_session();
	        when().I_add_student_profile();
	        then().Current_student_profile_is_updated();
	    }
}
