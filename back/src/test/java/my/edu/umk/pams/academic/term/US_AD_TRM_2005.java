package my.edu.umk.pams.academic.term;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentIsCurrent;
import my.edu.umk.pams.academic.term.stage.WhenIEnrollTheCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to enroll the classes so that I can view the current enrollment info")
@Submodule("Term")
public class US_AD_TRM_2005
		extends SpringScenarioTest<GivenIAmStudent, WhenIEnrollTheCourses, ThenTheEnrollmentIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_2005.class);
	private static final String PROGRAM_CODE = "A01-MASTER-0001";

	@ProvidedScenarioState
	private String faculty = "A01";

	@Test
	@Rollback(true)
	public void studentViewEnrollmentCourses() {
		given().I_am_a_student_in_current_academic_session();
		when().I_enroll_the_courses_for_program_$(PROGRAM_CODE);
		then().the_enrollment_info_is_current();

	}

}
