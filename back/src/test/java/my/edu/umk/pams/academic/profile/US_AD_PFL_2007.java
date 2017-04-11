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
import my.edu.umk.pams.academic.profile.stage.ThenStudentRegisteredCourse;
import my.edu.umk.pams.academic.profile.stage.WhenIWantViewStudentRegisteredCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to view student registration courses, so that I know student registered courses in current semester")
public class US_AD_PFL_2007 extends SpringScenarioTest<GivenIAmAdministrator, WhenIWantViewStudentRegisteredCourse, ThenStudentRegisteredCourse> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2007.class);
	private static final String IDENTITY_NO = "A17P001";

	@Test
	@Rollback
	public void scenario2007(){
		String username  = "cps";
    	String password  = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().I_want_view_student_registered_course_$(IDENTITY_NO);
		then().Student_registered_course();
	}
}
