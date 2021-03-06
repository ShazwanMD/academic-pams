package my.edu.umk.pams.academic.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenMatricNoUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIGenerateMatricNo;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_TEST_CLASS extends SpringScenarioTest<GivenIAmAdministrator, WhenIGenerateMatricNo, ThenMatricNoUpdated> {


	private static final Logger LOG = LoggerFactory.getLogger(US_TEST_CLASS.class);
	
	@Test
	@Rollback
	public void scenarioTEST(){
		String username = "mgseb";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().student_transfer_faculty()
			.and().student_switch_studyMode();
		then().new_matricNo_generated();
		
	}
	
}
