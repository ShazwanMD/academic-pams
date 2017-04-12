package my.edu.umk.pams.academic.planner;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenNewCohortIsUpdated;

import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateCohort;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to update cohort for a faculty so that updated group student in the schedule by intake code.")
@Issue("PAMA-49")
@Submodule("Planner")


public class US_AD_PNR_1013
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateCohort, ThenNewCohortIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1013.class);
	
	@ProvidedScenarioState
	private String CODE = "A01/MASTER/0008/CHRT/0001";

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().Admin_update_cohort_to_faculty_code_$(CODE);
		then().new_cohort_is_updated_$(CODE);
	}

}
