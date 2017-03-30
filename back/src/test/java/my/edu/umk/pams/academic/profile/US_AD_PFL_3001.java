package my.edu.umk.pams.academic.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenIKnowStudentRegisteredCourseandPaymentStatus;
import my.edu.umk.pams.academic.profile.stage.WhenIViewCourseRegistration;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;

/*As a bursary, I want to view course registration details,
 * 		so that I know student registered courses 
 *			 and their payment status
 */


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_3001 extends SpringScenarioTest<GivenIAmBursary, WhenIViewCourseRegistration, ThenIKnowStudentRegisteredCourseandPaymentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3001.class);
	
	@Test
    @Rollback
    public void scenario3001() {
		given().I_am_a_bursary_in_$_academic_session("201720181");
		when().I_view_student_course_registration().
			and().when().I_view_student_payment_status();
		then().student_registered_courses_and_payment_status_is_viewed();
		
	
	}
	
}