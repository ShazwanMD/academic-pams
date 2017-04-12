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

import my.edu.umk.pams.academic.assessment.stage.WhenIAmUpdateExamVivaInfo;
import my.edu.umk.pams.academic.assessment.stage.thenExamVivaInfoCurrent;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin faculty/admin postgraduate,I want to update exam/viva info	So that I can update viva/exam information if there is problem")
public class US_AD_ASMT_3003 extends SpringScenarioTest<GivenIAmAdministrator, WhenIAmUpdateExamVivaInfo, thenExamVivaInfoCurrent> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3003.class);

	@Test
	@Rollback
	public void scenarioExam(){
		String username = "mgseb";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_update_examination_info();
		then().exam_info_current();
		
	}

	@Test
	@Rollback
	public void scenarioViva(){
		String username = "cps";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_update_viva_info();
		then().viva_info_current();
		
	}
}
