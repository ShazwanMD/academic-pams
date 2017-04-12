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
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenStudentResultReviewed;
import my.edu.umk.pams.academic.assessment.stage.WhenReviewStudentResult;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view student results, so that I can know my results.")

public class US_AD_ASMT_3007 extends SpringScenarioTest<GivenIAmAdministrator, WhenReviewStudentResult, ThenStudentResultReviewed> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3007.class);
	
	private String ACADEMIC_SESSION = "201720181";
	
	@Test
	@Rollback
	public void scenario3007_cps(){
		
		String USERNAME = "cps";
		String PASSWORD = "abc123";
		
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
			when().I_review_result();
				then().result_student_reviewed();
	}
	
	@Test
	@Rollback
	public void scenario3007_mgseb(){
					
		String USERNAME = "mgseb";
		String PASSWORD = "abc123";
					
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
				when().I_review_result();
					then().result_student_reviewed();			


	}
}
