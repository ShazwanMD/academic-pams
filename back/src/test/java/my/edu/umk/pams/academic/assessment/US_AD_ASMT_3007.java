package my.edu.umk.pams.academic.assessment;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenStudentResultReviewed;
import my.edu.umk.pams.academic.assessment.stage.WhenReviewStudentResult;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view student results, so that I can know my results.")
@JGivenStage
public class US_AD_ASMT_3007 extends SpringScenarioTest<GivenIAmAdministrator, WhenReviewStudentResult, ThenStudentResultReviewed> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3007.class);
	
	private String ACADEMIC_SESSION = "201720181";
	
	@ProvidedScenarioState
	private String matricNo = "A17P001";
	//input student mark
	@ProvidedScenarioState
	private int mark = 50;
	
/*	@Test
	@Rollback
	@Pending
	public void scenario3007_cps(){
		String USERNAME = "cps";
		String PASSWORD = "abc123";
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
			when().I_review_result();
				then().result_student_reviewed();
	}*/
	
	@Test
	@Rollback
	public void scenario3007_mgseb() throws Exception{
					
		String USERNAME = "mgseb";
		String PASSWORD = "abc123";
					
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
				when().I_review_result().i_review_student_mark();
					then().result_student_reviewed();			


	}
}
