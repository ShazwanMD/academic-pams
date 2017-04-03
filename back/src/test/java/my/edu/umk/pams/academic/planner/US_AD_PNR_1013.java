package my.edu.umk.pams.academic.planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenNewCohortIsUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCohort;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateCohort;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

/*Given : I Am Admin
When : Admin Update Cohort 
Then :  New Cohort Is Updated.
@author zaida_n
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PNR_1013
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateCohort, ThenNewCohortIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1013.class);

	// refer to data/AD_FCTY.sql
	public static final String FACULTY_CODE = "";

	public static final String COURSE_CODE = "";

	@Test
	@Rollback(false)
	public void scenario1() {
		given().I_am_a_CPS_administrator().and().I_pick_course_$(COURSE_CODE);
		when().Admin_update_cohort_to_faculty_code_$(FACULTY_CODE);
		then().new_cohort_is_updated();
	}

}
