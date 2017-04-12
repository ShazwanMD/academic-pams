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
import my.edu.umk.pams.academic.profile.stage.ThenCourseRegistrationDetailReviewed;
import my.edu.umk.pams.academic.profile.stage.WhenReviewCourseRegistrationDetails;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration (classes = TestAppConfiguration.class)
@As("As a supervisor, I want to view course registration details so that I know my student registered courses for supervision purpose")
public class US_AD_PFL_5002 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenReviewCourseRegistrationDetails, ThenCourseRegistrationDetailReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_5002.class);
	
	private static String STUDENT_NO = "A17P001";
	
	@Test
	@Rollback
	public void scenario5002(){
		given().i_am_a_staff_in_current_academic_session();
			when().supervisor_review_course_registration_info_for_$(STUDENT_NO);
				then().course_registration_details_reviewed();
		
		
	}
	
}
