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
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view student results, so that I can know my results.")

public class US_AD_ASMT_1002 extends SpringScenarioTest<GivenIAmStudent, WhenReviewStudentResult, ThenStudentResultReviewed>{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_1002.class);
	
	private String ACADEMIC_SESSION = "201720181";
	
	@Test
	@Rollback
	public void scenario10002(){
		given().I_am_a_student_in_$_academic_session(ACADEMIC_SESSION);
				when().I_review_result();
						then().result_student_reviewed();
		
		
	}
	
}
