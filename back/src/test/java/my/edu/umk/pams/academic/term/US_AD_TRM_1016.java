package my.edu.umk.pams.academic.term;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheDetailsOfferedCoursesInfoIsCurrent;
import my.edu.umk.pams.academic.term.stage.WhenIViewTheDetailsOfOfferedCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to view the details of the offered courses so that I know the current course's details info")
@Submodule("Term")
public class US_AD_TRM_1016 extends
		SpringScenarioTest<GivenIAmStudent, WhenIViewTheDetailsOfOfferedCourses, ThenTheDetailsOfferedCoursesInfoIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1016.class);
	private static final String PROGRAM_CODE = "FIAT/MASTER/PBH";

	@ProvidedScenarioState
	private String faculty = "A07";

	@Test
	@Rollback
	public void scenario01() {
		given().I_am_a_student_in_current_academic_session();
		when().I_view_the_details_offered_courses_for_program_$(PROGRAM_CODE);
		then().the_details_offered_courses_info_is_current();

	}
}