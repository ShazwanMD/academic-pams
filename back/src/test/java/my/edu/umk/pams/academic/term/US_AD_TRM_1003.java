package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheSectionsIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIUpdateSections;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to update the sections so that the sections will be updated")
@Submodule("Term")
public class US_AD_TRM_1003
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateSections, ThenTheSectionsIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1003.class);

	@Test
	@Rollback
	public void adminUpdateSections() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_update_sections_for_offering();
		then().the_sections_is_updated();
	}
}
