package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheStudentCanEnrol;
import my.edu.umk.pams.academic.term.stage.WhenICreateSections;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
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
@As("As a academic administrator, I want to create a section for student so that the students can enroll")
@Submodule("Term")
public class US_AD_TRM_1002
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenICreateSections, ThenTheStudentCanEnrol> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1002.class);
	public static final String FACULTY_CODE = "A10";
	public static final String PROGRAM_CODE = "A10";

	@Test
	@Rollback(true)
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_faculty_$(FACULTY_CODE).and()
				.I_pick_program_$(PROGRAM_CODE);
		when().I_create_sections_for_offering();
		then().the_student_can_enrol();
	}
}
