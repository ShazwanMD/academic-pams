package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenFacultyHasCourse;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zaida_nawi
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to set up courses for a faculty so that a faculty will be populated with courses")
@Issue("PAMA-19")
@Submodule("Planner")

public class US_AD_PNR_1006
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddCourse, ThenFacultyHasCourse> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1006.class);
	public static final String FACULTY_CODE = "A01";

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().Admin_add_a_course_to_faculty_code_$(FACULTY_CODE);
		then().faculty_has_courses();
	}
}
