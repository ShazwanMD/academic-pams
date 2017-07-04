package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCohortIsAdded;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCohortForAFaculty;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
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
@As("As an academic administrator, i want to set up cohort for a faculty so that i can group student in the schedule by intake code.")
@Issue("PAMA-22")
@Submodule("Planner")
public class US_AD_PNR_1008
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddCohortForAFaculty, ThenCohortIsAdded> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1008.class);
	public static final String PROGRAM_CODE = "FIAT/PHD/0001";

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().Admin_add_cohort_for_a_faculty(PROGRAM_CODE);
		then().cohort_is_added();
	}

}
