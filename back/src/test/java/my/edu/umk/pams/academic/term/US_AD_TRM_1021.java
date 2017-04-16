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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenCourseDropped;
import my.edu.umk.pams.academic.term.stage.WhenDropCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to drop an enrollment course so that I can view the dropped course")
@Submodule("Term")

public class US_AD_TRM_1021 extends SpringScenarioTest<GivenIAmStudent, WhenDropCourse, ThenCourseDropped> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1021.class);

	@Test
	@Rollback(true)
	public void scenario01() {
		given().I_am_a_student_in_current_academic_session();
		when().I_want_to_drop_enrollment_course();
		then().The_course_enrollment_are_dropped();
	}
}
