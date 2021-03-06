package my.edu.umk.pams.academic.term;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenITransferSection;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator,I want to transfer section so that the enrollment is updated")
@Submodule("Term")
public class US_AD_TRM_1008
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenITransferSection, ThenTheEnrollmentIsUpdated> {

	@Test
	@Rollback(true)
	public void adminTransferSections() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_transfer_section();
		then().the_enrollment_is_updated();
	}
}
