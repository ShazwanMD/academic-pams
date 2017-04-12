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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenEnrollmentDateIsClose;
import my.edu.umk.pams.academic.term.stage.ThenKnowTheEnrollmentIntervalPeriod;
import my.edu.umk.pams.academic.term.stage.ThenTheDateEnrollmentIsReview;
import my.edu.umk.pams.academic.term.stage.WhenICloseTheEnrollmentDate;
import my.edu.umk.pams.academic.term.stage.WhenWantToViewOpenDateOfEnrollment;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**
 * @author zaida_nawi
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Pending
@As("As a student, I want to view open date of enrollment, so that I know the enrollment interval period.")

public class US_AD_TRM_1017 extends
		SpringScenarioTest<GivenIAmStudent, WhenWantToViewOpenDateOfEnrollment, ThenTheDateEnrollmentIsReview> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1017.class);

	@Test
	@Rollback()
	public void scenario01() {
		given().I_am_a_student_in_current_academic_session();
		when().Want_to_view_open_date_of_enrollment();
		then().Know_the_enrollment_interval_period();

	}
}
