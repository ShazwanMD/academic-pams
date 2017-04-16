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
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenStudyCenterUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateStudyCenter;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want view and update Study Center so that Study Center is viewed and updated")
@Issue("PAMA-53")
@Submodule("Planner")
public class US_AD_PNR_1019
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateStudyCenter, ThenStudyCenterUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1019.class);

	@ProvidedScenarioState
	private String CODE = "A";

	@Test
	@Rollback
	public void UpdateStudyCenter() {
		given().I_am_a_CPS_administrator();
		when().Admin_update_study_center_$(CODE);
		then().Study_Center_is_updated();
	}

}
