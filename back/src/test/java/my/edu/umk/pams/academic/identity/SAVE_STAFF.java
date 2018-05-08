package my.edu.umk.pams.academic.identity;

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
import my.edu.umk.pams.academic.identity.stage.ThenNewStaffAdded;
import my.edu.umk.pams.academic.identity.stage.WhenIAmAddNewStaff;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class SAVE_STAFF extends SpringScenarioTest<GivenIAmAdministrator,WhenIAmAddNewStaff,ThenNewStaffAdded> {
	
	private static final Logger LOG = LoggerFactory.getLogger(SAVE_STAFF.class);
	
	@Test
	@Rollback
	public void save_new_staff(){
		given().i_am_a_$_administrator_in_current_academic_session("root", "abc123");
		when().I_am_add_new_staff();
		
	}

}
