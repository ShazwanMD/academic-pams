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

import my.edu.umk.pams.academic.assessment.stage.ThenExamVivaCreated;
import my.edu.umk.pams.academic.assessment.stage.WhenIAmSetupExamVivaInfo;
import my.edu.umk.pams.academic.assessment.stage.WhenSetupGradeBook3002;
import my.edu.umk.pams.academic.assessment.stage.WhenSetupGradeCode;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin faculty/admin postgraduate,I want to generate exam/viva info So that I can setup examination/viva information.")
@JGivenStage
public class US_AD_ASMT_3002 extends SpringScenarioTest<GivenIAmAdministrator, WhenIAmSetupExamVivaInfo, ThenExamVivaCreated> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3002.class);
	
	@ProvidedScenarioState
	private static String staffMgseb = "01001A";
	
	@ProvidedScenarioState
	private static String staffCps = "01002A";
	
	@Test
	@Rollback
	public void scenario3002(){
		
		String username = "mgseb";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
//		addStage(WhenSetupGradeCode.class).setup_gradeCode();
		when().i_setup_assessment_info();
		addStage(WhenSetupGradeBook3002.class).generate_gradebook();
		then().exam_viva_created();
		
		
	}

/*	@Test
	@Rollback
	public void scenarioViva(){
		
		String username = "cps";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_setup_viva();
		then().exam_viva_created();
		
		
	}*/
}
