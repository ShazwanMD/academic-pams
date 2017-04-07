/**
 * @author asyikin.mr 
 */
package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.term.stage.ThenTheStatusAppointmentIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIWantToUpdateAppointmentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to update appointment status , so that the status of appoinment is updated")
public class US_AD_TRM_1005 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIWantToUpdateAppointmentStatus, ThenTheStatusAppointmentIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1005.class);

	@Test
	@Rollback(true)
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_update_appointment_status();
		then().the_appointment_status_is_updated();
	}
}
