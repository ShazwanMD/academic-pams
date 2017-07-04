package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheOfferedCourseHasAMaxAllowQuota;
import my.edu.umk.pams.academic.term.stage.WhenIWantToSetCapacityForOfferedCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to set the capacity for an offered course in current academic session so that the offered course has a maximum allow quota")
@Submodule("Term")
public class US_AD_TRM_1006 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIWantToSetCapacityForOfferedCourse, ThenTheOfferedCourseHasAMaxAllowQuota> {

	public static final String FACULTY_CODE = "A10";
	
	

	@Test
	@Rollback(true)
	public void adminSetOfferingCapacity() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_faculty_$(FACULTY_CODE);
		when().I_create_and_set_offering_capacity();
		then().the_offered_course_has_a_maximum_quota();
	}
}
