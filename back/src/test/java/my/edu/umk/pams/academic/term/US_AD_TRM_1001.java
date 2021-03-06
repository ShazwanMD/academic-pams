package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.annotation.As;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenOfferingMayHaveSection;
import my.edu.umk.pams.academic.term.stage.WhenIOfferCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to offer the courses to student so that the offered courses are ready for setup")
@Submodule("Term")
public class US_AD_TRM_1001
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIOfferCourse, ThenOfferingMayHaveSection> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1001.class);
	public static final String FACULTY_CODE = "A04";
	public static final String PROGRAM_CODE = "PBI-PHD-PCS";
	public static final String COURSE_CODE = "MCS";

	@Test
	@Rollback
	public void adminReadyForSectionsBySelectedProgram() throws Exception {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_faculty_$(FACULTY_CODE).and()
				.I_pick_program_$(PROGRAM_CODE);
		when().I_create_course_offerings_for_the_program_$(PROGRAM_CODE);
		then().the_offerings_may_begin_to_have_sections();
	}
	
	@Test
	@Rollback
	public void adminReadyForSectionsBySelectedCourse() throws Exception {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_faculty_$(FACULTY_CODE).and()
				.I_pick_program_$(PROGRAM_CODE);
		when().I_create_course_offerings_for_the_program_by_selected_course_$(COURSE_CODE);
		then().the_offerings_may_begin_to_have_sections();
	}
}
