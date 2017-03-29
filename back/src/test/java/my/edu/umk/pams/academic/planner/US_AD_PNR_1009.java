package my.edu.umk.pams.academic.planner;

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
import my.edu.umk.pams.academic.planner.stage.ThenSetCreditHasIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenISetCreditForAFaculty;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

/*
 * @author zaida_ain
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)


public class US_AD_PNR_1009 extends
SpringScenarioTest<GivenIAmCPSAdministrator, WhenISetCreditForAFaculty, ThenSetCreditHasIntroduced>{
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1009.class);

	@Test
	@Rollback(false)
	public void scenario1() {
		given().I_am_a_CPS_administrator();
	//	when().I_set_credit_for_a_faculty();
	//	then().set_credit_has_introduced();

}
	
}


