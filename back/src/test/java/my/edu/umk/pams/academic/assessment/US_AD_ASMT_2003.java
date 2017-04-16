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
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenExamVivaInfoReviewed;
import my.edu.umk.pams.academic.assessment.stage.WhenIReviewExamVivaInfo;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor,I want to view exam/viva info So that I can view viva/exam information.")
public class US_AD_ASMT_2003
		extends SpringScenarioTest<GivenIAmAcademicStaff, WhenIReviewExamVivaInfo, ThenExamVivaInfoReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2003.class);

	@ProvidedScenarioState
	private String facultyCode = "A10";

	@Test
	@Rollback
	public void scenarioEXAM() {
		given().i_am_a_staff_in_current_academic_session();
		when().i_review_examination_info();
		then().exam_info_reviewed();
	}

	@Test
	@Rollback
	public void scenarioVIVA() {
		given().i_am_a_staff_in_current_academic_session();
		when().i_review_viva_info();
		then().viva_info_reviewed();
	}

}
