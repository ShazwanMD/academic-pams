package my.edu.umk.pams.academic.term;

//@author:asyikin
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenIViewTheCurrentEnrollmentCourses;
import my.edu.umk.pams.academic.term.stage.WhenIAddEnrollmentCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to add an enrollment course so that I can view the added course")
@Submodule("Term")
public class US_AD_TRM_2009
		extends SpringScenarioTest<GivenIAmStudent, WhenIAddEnrollmentCourses, ThenIViewTheCurrentEnrollmentCourses> {
	
	public static final String PROGRAM_CODE = "FIAT-PHD-PBT";

	@Test
	@Rollback(true)
	public void studentAddEnrollmentCourses() {
		given().I_am_a_student_in_current_academic_session().and().I_pick_program_$(PROGRAM_CODE);
		when().I_add_enrollment_courses();
		then().I_view_the_current_enrollment_courses();
	}
}