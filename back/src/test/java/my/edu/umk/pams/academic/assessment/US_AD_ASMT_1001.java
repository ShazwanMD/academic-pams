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

import my.edu.umk.pams.academic.assessment.stage.ThenExamVivaInfoViewed;
import my.edu.umk.pams.academic.assessment.stage.WhenViewExamVivaInfo;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view exam/viva info So that I can view exam/viva information")

public class US_AD_ASMT_1001 extends SpringScenarioTest<GivenIAmStudent, WhenViewExamVivaInfo, ThenExamVivaInfoViewed >{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_1001.class);
	
	@Test
    @Rollback
    public void scenario_1001_viva() {
		
		given().I_am_a_student_in_current_academic_session();
		when().i_want_view_viva_info();
		then().viva_info_viewed();
		
	}
	
	@Test
    @Rollback
    public void scenario_1001_exam() {
		
		given().I_am_a_student_in_current_academic_session();
		when().i_want_view_exam_info();
		then().exam_info_viewed();
		
	}
	
}
