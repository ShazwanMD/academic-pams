package my.edu.umk.pams.academic.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import org.slf4j.Logger;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenIKnowStudentRegisteredCourseandPaymentStatus;
import my.edu.umk.pams.academic.profile.stage.WhenIViewCourseRegistration;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a bursary, I want to view course registration details so that I know student registered courses and their payment status")
public class US_AD_PFL_3001 extends
		SpringScenarioTest<GivenIAmBursary, WhenIViewCourseRegistration, ThenIKnowStudentRegisteredCourseandPaymentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3001.class);

	private static final String IDENTITY_NO = "A17P002";

	@Test
	@Rollback
	public void scenario3001() {
		given().I_am_a_bursary_in_$_academic_session("201720181");
		when().I_view_student_$_course_registration(IDENTITY_NO).
			and().when().I_view_student_payment_status();
		then().student_registered_courses_and_payment_status_is_viewed();

	}

}
