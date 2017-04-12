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

import my.edu.umk.pams.academic.assessment.stage.WhenViewStudentResult;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor, I want to view student results, so that I know students' result.")


public class US_AD_ASMT_2005 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenViewStudentResult, ThenStudentResultIsViewed>{
	
private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2005.class);
	
	private String ACADEMIC_SESSION = "201720181";
	
	@Test
	@Rollback
	public void scenario2005(){
		given().i_am_a_staff_in_$_academic_session(ACADEMIC_SESSION);
			when().supervisor_review_student_result();
				then().supervisor_view_result_student();
		
		
	}
}
