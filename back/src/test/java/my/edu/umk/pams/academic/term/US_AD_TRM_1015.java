package my.edu.umk.pams.academic.term;
/**
 * @author asyikin.mr and ziana
 */

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenICanChoose;
import my.edu.umk.pams.academic.term.stage.WhenIWantToViewTheOfferedCoursesByAcademicSession;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

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
@As("As a student in current academic session and I pick program, I browse the offered courses by program I picked, then  i can choose which section to enroll")
@Submodule("Term")
public class US_AD_TRM_1015
		extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewTheOfferedCoursesByAcademicSession, ThenICanChoose> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1015.class);
	public static final String OFFERING_CANONICAL_CODE = "A01/PHD/0001/DDA2113";

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_student_in_current_academic_session().and().I_pick_offering_$(OFFERING_CANONICAL_CODE);
		when().I_browse_the_offered_course_by_program_I_picked();
		then().i_can_choose_which_section_to_enroll();

	}
}
