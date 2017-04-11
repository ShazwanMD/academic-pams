package my.edu.umk.pams.academic.profile;

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

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenIGetCurrentStudentStatus;
import my.edu.umk.pams.academic.profile.stage.WhenIAccessStudentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to view student activation status so that I know student activation status")
public class US_AD_PFL_2003
		extends SpringScenarioTest<GivenIAmAdministrator, WhenIAccessStudentStatus, ThenIGetCurrentStudentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2003.class);

	private static final String IDENTITY_NO = "A17P001";

	@Test
	@Rollback
	public void access_student_status_by_CPS() {
		String username  = "cps";
		String password  = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_access_student_status(IDENTITY_NO);
		then().i_get_the_students_current_status();
	}

	@Test
	@Rollback
	public void access_student_status_by_MGSEB() {
		String username  = "mgseb";
		String password  = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().i_access_student_status(IDENTITY_NO);
		then().i_get_the_students_current_status();
	}
}
