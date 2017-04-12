package my.edu.umk.pams.academic.planner;

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
import my.edu.umk.pams.academic.planner.stage.ThenStudyCenterIsIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenAdminSetUpStudyCenter;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

/**
 * @author zaida_nawi
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin academic,I want to set up study center, so that the study center is intoduced.")
@Issue("PAMA-52")
@Submodule("Planner")
public class US_AD_PNR_1016
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminSetUpStudyCenter, ThenStudyCenterIsIntroduced> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1016.class);

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().Admin_set_up_study_center();
		then().study_center_is_intoduced();

	}
}
