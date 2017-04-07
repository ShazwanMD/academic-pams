package my.edu.umk.pams.academic.term;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenOfferingMayHaveSection;
import my.edu.umk.pams.academic.term.stage.WhenIOfferCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
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
@As("As a academic administrator, I want to offer the courses to student so that the offered courses are ready for setup")
public class US_AD_TRM_1001
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIOfferCourse, ThenOfferingMayHaveSection> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1001.class);
	public static final String FACULTY_CODE = "A01";
	public static final String PROGRAM_CODE = "A01/MASTER/0001";

	@Test
	@Rollback
	public void readyForSections() {
		given().I_am_a_CPS_administrator_in_current_academic_session()
                .and().I_pick_faculty_$(FACULTY_CODE)
                .and().I_pick_program_$(PROGRAM_CODE);
		when().I_create_course_offerings_for_the_program();
		then().the_offerings_may_begin_to_have_sections();
	}
}
