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
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentStatusIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIUpdateEnrollmentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to update enrollment status for student so that the enrollment status is updated")
@Submodule("Term")
public class US_AD_TRM_1009 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateEnrollmentStatus, ThenTheEnrollmentStatusIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1009.class);
	private static final String PROGRAM_CODE = "FKP-PHD-PAM";

	@Test
	@Rollback
	public void adminUpdateEnrollment() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_update_enrollment_status_for_program_$(PROGRAM_CODE);
		then().the_enrollment_status_is_updated();

	}

}
