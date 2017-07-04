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
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenStudentResultReviewed;
import my.edu.umk.pams.academic.assessment.stage.WhenReviewStudentResult;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor, I want to view student results, so that I know students' result.")

@JGivenStage
public class US_AD_ASMT_2005 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenReviewStudentResult, ThenStudentResultReviewed>{
	
private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2005.class);
	
	private String ACADEMIC_SESSION = "201720181";
	
	@ProvidedScenarioState
	public static String matricNo = "A17P001";
	
	@ProvidedScenarioState
	private int mark = 50;
	
	@Test
	@Rollback
	public void scenario2005(){
		given().i_am_a_staff_in_$_academic_session(ACADEMIC_SESSION);
			when().I_review_result();
				then().result_student_reviewed();

		
	}
}
