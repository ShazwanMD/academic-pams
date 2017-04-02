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
import my.edu.umk.pams.academic.profile.stage.ThenResearchInfoIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIReviewResearchInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_1008 extends SpringScenarioTest<GivenIAmStudent, WhenIReviewResearchInfo, ThenResearchInfoIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1008.class);
	
	
	@Test
	@Rollback
	public void scenario1008(){
		
		given().I_am_a_student_in_current_academic_session();
		when().I_review_research_info();
		then().Research_info_is_current();
	}
}