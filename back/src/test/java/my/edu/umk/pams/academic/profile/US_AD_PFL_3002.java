package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;

import my.edu.umk.pams.academic.profile.stage.ThenIKnowStudentCurrentStatus;

import my.edu.umk.pams.academic.profile.stage.WhenIViewStudentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a bursary, I want to view student activation status so that I can know the students current status")
public class US_AD_PFL_3002
		extends SpringScenarioTest<GivenIAmBursary, WhenIViewStudentStatus, ThenIKnowStudentCurrentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3002.class);
	private static final String IDENTITY_NO = "A17P001";

	@Test
	@Rollback
	public void scenario3002() {
		given().I_am_a_bursary_in_current_academic_session();
		when().I_view_student_$_status(IDENTITY_NO);
		then().I_know_student_$_current_status(IDENTITY_NO);
	}

}
