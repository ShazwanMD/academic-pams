package my.edu.umk.pams.academic.term;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentIsUpdated;
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentStatusIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenITransferSection;
import my.edu.umk.pams.academic.term.stage.WhenIUpdateEnrollmentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

public class US_AD_TRM_1008 extends
SpringScenarioTest<GivenIAmCPSAdministrator, WhenITransferSection, ThenTheEnrollmentIsUpdated> {
	
	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().I_transfer_section();
		then().the_enrollment_is_updated();
	}

}


