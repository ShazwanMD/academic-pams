package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheAdvisorIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenChangeAdvisor;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator,I want to change appointed supervisor for student so that the appointed supervisor is updated")
@Submodule("Term")
public class US_AD_TRM_1010
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenChangeAdvisor, ThenTheAdvisorIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1010.class);

	@Test
	@Rollback(true)
	public void adminChangeAdvisor() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_want_to_change_advisor();
		then().The_advisor_is_updated();
	}
}
