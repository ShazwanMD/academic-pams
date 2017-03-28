package my.edu.umk.pams.academic.planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenTheAcademicSessionIsCreated;
import my.edu.umk.pams.academic.planner.stage.WhenICreateAcademicSession;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

/**
 * @author zaida.n
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PNR_1010 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenICreateAcademicSession, ThenTheAcademicSessionIsCreated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1010.class);

	@Test
	@Rollback(true)
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_create_academic_session();
		then().the_academic_session_is_created();
	}
}
