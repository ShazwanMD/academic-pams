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
import my.edu.umk.pams.academic.profile.stage.ThenLecturerReviewedCourseAndResearchInfo;

import my.edu.umk.pams.academic.profile.stage.WhenLecturerReviewCourseInfoAndResearchInfo;

import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_5004 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenLecturerReviewCourseInfoAndResearchInfo, ThenLecturerReviewedCourseAndResearchInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_5005.class);
	
	  private static final String IDENTITY_NO = "A17P002";
	  private static final String IDENTITY_NO2 = "A17P001";
	
	  
	@Test
	@Rollback
	public void scenario5004(){
		given().i_am_a_staff_in_current_academic_session();
		when().Lecturer_review_course_info_for_$(IDENTITY_NO).and().Lecturer_review_research_info_for_$(IDENTITY_NO2);
		then().Lecturer_review_course().and().Lecturer_review_research_info();
		
	}
}
