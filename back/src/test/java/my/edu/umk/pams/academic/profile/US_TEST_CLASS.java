package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenMatricNoUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIGenerateMatricNo;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_TEST_CLASS extends SpringScenarioTest<GivenIAmAdministrator, WhenIGenerateMatricNo, ThenMatricNoUpdated> {


	private static final Logger LOG = LoggerFactory.getLogger(US_TEST_CLASS.class);
	
	@Test
	@Rollback
	public void scenarioTEST(){
		String username = "cps";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_generate_new_matricNo();
		then().new_matricNo_generated();
		
	}
	
}
