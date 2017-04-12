package my.edu.umk.pams.academic.planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenNewAcademicSessionInfoIsCreated;
import my.edu.umk.pams.academic.planner.stage.WhenIAddNewAcademicSessionInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to create new academic session info so that the new academic session info is created.")
@Issue("PAMA-19")
@Submodule("Planner")

public class US_AD_PNR_1010 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddNewAcademicSessionInfo, ThenNewAcademicSessionInfoIsCreated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1010.class);

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_add_new_academic_session_info();
		then().New_academic_session_info_is_created();
	}
}
