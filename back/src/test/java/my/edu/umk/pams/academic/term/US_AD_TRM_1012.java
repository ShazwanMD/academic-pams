package my.edu.umk.pams.academic.term;
/**
 * @author zaida_nawi
 **/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenEnrollmentDateIsClose;
import my.edu.umk.pams.academic.term.stage.WhenICloseTheEnrollmentDate;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Pending
@As("As academic admininstrator, I want to close the enrollment date so that the date of enrolment is close")

public class US_AD_TRM_1012 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenICloseTheEnrollmentDate, ThenEnrollmentDateIsClose> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1012.class);
	private static final String PROGRAM_CODE = "201820181";



	@Test
	@Rollback()
	public void scenario01() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_close_the_date_of_enrollment_for_program_$(PROGRAM_CODE);
		then().Enrollment_date_is_close();

	}

}
