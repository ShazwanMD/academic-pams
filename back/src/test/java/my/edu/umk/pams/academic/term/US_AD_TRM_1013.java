package my.edu.umk.pams.academic.term;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheAdmissionStatusIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIUpdateAdmissionStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to update admission status for student under selected program so that the admission status is updated")
@Submodule("Term")
public class US_AD_TRM_1013 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateAdmissionStatus, ThenTheAdmissionStatusIsUpdated> {
	
	private static final String PROGRAM_CODE = "FIAT-PHD-PBT";

	@Test
	@Rollback(true)
	public void adminUpdateAdmissionStatus() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_update_admission_status_for_program_$(PROGRAM_CODE);
		then().the_admission_status_is_updated();

	}

}
