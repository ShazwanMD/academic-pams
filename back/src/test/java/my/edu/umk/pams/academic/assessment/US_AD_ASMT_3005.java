package my.edu.umk.pams.academic.assessment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenGradingEntryControlled;
import my.edu.umk.pams.academic.assessment.stage.WhenSetupGradingEntryInterval;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin faculty/admin postgraduate,I want to setup grading entry interval, So that I can control mark entry.")

public class US_AD_ASMT_3005 extends SpringScenarioTest <GivenIAmAdministrator, WhenSetupGradingEntryInterval, ThenGradingEntryControlled> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3005.class);
	
private String ACADEMIC_SESSION = "201720181";
	
	@Test
	@Rollback
	public void scenario3005_cps(){
		
		String USERNAME = "cps";
		String PASSWORD = "abc123";
		
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
			when().I_setup_grading_entry_interval();
				then().grading_entry_interval_is_controlled();
	}
	
	@Test
	@Rollback
	public void scenario3005_mgseb(){
					
		String USERNAME = "mgseb";
		String PASSWORD = "abc123";
					
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
			when().I_setup_grading_entry_interval();
					then().grading_entry_interval_is_controlled();			


	}

	
	
}
