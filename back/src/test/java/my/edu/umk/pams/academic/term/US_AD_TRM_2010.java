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
import my.edu.umk.pams.academic.term.stage.ThenICanViewTheWithdrawnCourse;
import my.edu.umk.pams.academic.term.stage.WhenWithdrawEnrollmentCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to withdraw an enrollment course so that I can view the withdrawn course.")
@Submodule("Term")
public class US_AD_TRM_2010
		extends SpringScenarioTest<GivenIAmStudent, WhenWithdrawEnrollmentCourse, ThenICanViewTheWithdrawnCourse> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_2010.class);

	@Test
	@Rollback(true)
	public void studentWithdrawEnrollmentCourse() {
		given().I_am_a_student_in_current_academic_session();
		when().I_withdraw_enrollment_course();
		then().i_can_view_the_withdrawn_course();
	}
}
