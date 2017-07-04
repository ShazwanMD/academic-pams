package my.edu.umk.pams.academic.profile;

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

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenStudentBarringStatusIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenBursaryViewBarringStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a bursary, I can view the barring status of students so that I can know the discipline issues for the student")
@Submodule("Profile")
@Issue("PAMA-57")
public class US_AD_PFL_3003
		extends SpringScenarioTest<GivenIAmBursary, WhenBursaryViewBarringStatus, ThenStudentBarringStatusIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3003.class);
	private static final String IDENTITY_NO = "A17P002";
	
	@Test
	@Rollback
	public void scenario3003() {
		given().I_am_a_bursary_in_current_academic_session();
		when().I_view_barring_status_$(IDENTITY_NO);
		then().Student_status_current();
	}
}
