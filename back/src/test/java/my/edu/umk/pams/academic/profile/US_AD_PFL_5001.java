package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenStudentProfileReviewed;
import my.edu.umk.pams.academic.profile.stage.WhenReviewStudentProfileInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration (classes = TestAppConfiguration.class)

/*
 * As a supervisor,
 * 		I want to view student profile information,
 * 			so that I know my student profile info for supervision purpose.
*/


public class US_AD_PFL_5001 extends SpringScenarioTest <GivenIAmAcademicStaff, WhenReviewStudentProfileInfo, ThenStudentProfileReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger((US_AD_PFL_5001.class));
	
	private static String StudentNo = "A17P001";
	
	@Test
	@Rollback
	public void scenario5001(){
		given().I_am_a_staff_in_current_academic_session();
			when().supervisor_review_student_profile(StudentNo);
				then().student_profile_reviewed();
	}
	
}
