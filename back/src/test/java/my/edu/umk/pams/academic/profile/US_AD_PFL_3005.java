package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenBursaryReviewedStudentPaymentStatus;
import my.edu.umk.pams.academic.profile.stage.WhenBursaryReviewStudentPaymentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a bursary, I want to view payment status of students so that I can review payment status to make audit")
public class US_AD_PFL_3005 extends SpringScenarioTest<GivenIAmBursary, WhenBursaryReviewStudentPaymentStatus, ThenBursaryReviewedStudentPaymentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3005.class);

	@Test
	@Rollback
	public void scenario3005(){
		given().I_am_a_bursary_in_current_academic_session();
		when().Bursary_review_student_payment_status();
		then().Student_payment_status_reviewed();
	}

}
