package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCohortIsIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenISetUpCohortForAFaculty;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * I Am Admin 
 * I Set Up Cohort For A Faculty
 *  Cohort Is Introduced
 * 
 * @author zaida
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PNR_1005
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenISetUpCohortForAFaculty, ThenCohortIsIntroduced> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1005.class);
	public static final String PROGRAM_CODE = "FIAT/PHD/0001";

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		//when().I_setup_cohort_for_a_faculty(PROGRAM_CODE);
		//then().cohort_is_introduced();
	}

}
