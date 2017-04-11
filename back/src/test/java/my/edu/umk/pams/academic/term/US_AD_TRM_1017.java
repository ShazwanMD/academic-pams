package my.edu.umk.pams.academic.term;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenIKnowTheEnrollmentIntervalPeriod;
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenITransferSection;
import my.edu.umk.pams.academic.term.stage.WhenIWantToViewOpenDateOfEnrollment;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_TRM_1017 extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewOpenDateOfEnrollment, ThenIKnowTheEnrollmentIntervalPeriod> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1017.class);
	
	
	@Test
	@Rollback(true)
	public void scenario01() {
		given().I_am_a_student_in_current_academic_session();
		when().I_want_to_view_open_date_of_enrollment();
		then().i_know_the_enrollment_interval_period();

	}
}

	
