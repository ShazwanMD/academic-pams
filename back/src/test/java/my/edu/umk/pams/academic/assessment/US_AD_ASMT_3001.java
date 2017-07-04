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
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenGradeScaleUpdated;
import my.edu.umk.pams.academic.assessment.stage.WhenIAmUpdateGradeScale;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin faculty/admin postgraduate,I want to update grading scale So that I can setup grading scale.")
public class US_AD_ASMT_3001 extends SpringScenarioTest<GivenIAmAdministrator, WhenIAmUpdateGradeScale, ThenGradeScaleUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3001.class);
	
	@Test
	@Rollback
	public void scenario3001(){
		String username = "cps";
		String password = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when()
//		.i_setup_grading_scale()
		.and().i_update_grading_scale();
		then().grading_scale_updated();
		
	}
}
