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
import my.edu.umk.pams.academic.profile.stage.ThenStudentGraduationStatusReviewed;
import my.edu.umk.pams.academic.profile.stage.WhenBursaryReviewStudentGraduationStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_3004 extends SpringScenarioTest<GivenIAmBursary, WhenBursaryReviewStudentGraduationStatus, ThenStudentGraduationStatusReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3004.class);
	
	
	@Test
	@Rollback
	public void scenario3004(){
		given().I_am_a_bursary_in_current_academic_session();
		when().Bursary_Review_Student_Graduation_Status();
		then().Student_Graduation_Status_Reviewed();
		
	}
}