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

import my.edu.umk.pams.academic.assessment.stage.ThenStudentDetailsCurrent;
import my.edu.umk.pams.academic.assessment.stage.WhenIAmReviewStudentInfo;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin faculty/admin postgraduate,I want to view student info	So that I can view student’s subject registered.")
public class US_AD_ASMT_3000 extends SpringScenarioTest<GivenIAmAdministrator, WhenIAmReviewStudentInfo, ThenStudentDetailsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3000.class);
	
	@Test
	@Rollback
	public void scenario3000(){
		String username = "cps";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_review_student_info();
		then().student_details_current();
		
		
	}
}
