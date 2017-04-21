package my.edu.umk.pams.academic.assessment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenCourseRegistrationViewed;
import my.edu.umk.pams.academic.assessment.stage.WhenReviewMyCourseRegistration;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view course registration, So that I can view course registered")

public class US_AD_ASMT_1000 extends SpringScenarioTest<GivenIAmStudent, WhenReviewMyCourseRegistration, ThenCourseRegistrationViewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_1000.class);
	
	@ProvidedScenarioState
	public static String matricNo = "A17P001";
	
	@Test
    @Rollback
	public void senario1000() {
		
		given().I_am_a_student_in_current_academic_session();
		when().i_want_to_view_course_registration();
		then().course_registration_viewed();
	}
	
	
}
