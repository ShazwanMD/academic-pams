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
import my.edu.umk.pams.academic.profile.stage.ThenProfileIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIReviewProfile;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to view student activation status so that I know my current status")
@Submodule("Profile")

public class US_AD_PFL_1009 extends SpringScenarioTest<GivenIAmStudent, WhenIReviewProfile, ThenProfileIsCurrent> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1009.class);
	
	
	
	@Test
	@Rollback
	public void scenario1009(){
		given().I_am_a_student_in_current_academic_session();
		when().i_review_my_profile();
		then().profile_current();
		
	}

}
