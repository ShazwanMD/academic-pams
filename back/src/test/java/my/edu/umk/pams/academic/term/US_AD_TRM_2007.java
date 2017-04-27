package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentCoursesIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIWantToEnrollAdditionalOfferingCoursesToRepeatCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to enroll additional offering courses to repeat courses so that the enrollment courses is updated")
@Submodule("Term")
public class US_AD_TRM_2007 extends
		SpringScenarioTest<GivenIAmStudent, WhenIWantToEnrollAdditionalOfferingCoursesToRepeatCourses, ThenTheEnrollmentCoursesIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_2007.class);
	private static final String PROGRAM_CODE = "A01/MASTER/0001";

	@Test
	@Rollback
	public void studentViewOfferingCourses() {
		given().I_am_a_student_in_current_academic_session();
		when().I_want_to_enroll_additional_offering_courses_to_repeat_courses_for_program_$(PROGRAM_CODE);
		then().the_enrollment_courses_is_updated();
	}

}
