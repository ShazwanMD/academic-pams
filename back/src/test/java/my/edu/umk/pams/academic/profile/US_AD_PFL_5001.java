package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenStudentProfileReviewed;
import my.edu.umk.pams.academic.profile.stage.WhenReviewStudentProfileInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration (classes = TestAppConfiguration.class)
@As("As a supervisor, I want to view student profile information so that I know my student profile info for supervision purpose")
@Submodule("Profile")
@Issue("PAMA-63")
public class US_AD_PFL_5001 extends SpringScenarioTest <GivenIAmAcademicStaff, WhenReviewStudentProfileInfo, ThenStudentProfileReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_5001.class);
	private static String STUDENT_NO = "A17P001";
	
	@Test
	@Rollback
	public void scenario5001(){
		given().i_am_a_staff_in_current_academic_session();
			when().supervisor_review_student_profile(STUDENT_NO);
				then().student_profile_reviewed();
	}
	
}
