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
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenExamVivaSetup;
import my.edu.umk.pams.academic.assessment.stage.WhenUpdateGradeBook;
import my.edu.umk.pams.academic.assessment.stage.GivenAnEnrollment;
import my.edu.umk.pams.academic.assessment.stage.WhenIAmSetupExamViva;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor, I want to update exam/viva info So that I can update exam/viva information")
public class US_AD_ASMT_2001 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenIAmSetupExamViva, ThenExamVivaSetup> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2001.class);
	
	@ProvidedScenarioState
	private static String staffNo = "01001A";
	
	@Test
	@Rollback
	public void scenarioEXAM(){
		given().i_am_a_staff_in_current_academic_session();
		
//		addStage(WhenSetupGradeCode.class).setup_gradeCode();
		addStage(GivenAnEnrollment.class).create_enrollment();
		
		when().i_setup_assessments();	
//		
		addStage(WhenUpdateGradeBook.class).update_gradeBook();
		then().exam_setup();
		
	}
}
