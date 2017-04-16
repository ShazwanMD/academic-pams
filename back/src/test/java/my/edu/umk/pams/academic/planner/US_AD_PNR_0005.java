package my.edu.umk.pams.academic.planner;

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
import my.edu.umk.pams.academic.planner.stage.ThenProgramLevelUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateProgramLevel;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want update level of study for a faculty so that a new level of study is updated")
@Issue("PAMA-51")
@Submodule("Planner")
public class US_AD_PNR_0005 extends SpringScenarioTest<GivenIAmCPSAdministrator,WhenAdminUpdateProgramLevel, ThenProgramLevelUpdated>{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_0005.class);

	@ProvidedScenarioState
	private String CODE = "MASTER";
	
	@Test
	@Rollback
	public void UpdateProgramLevel() {
		given().I_am_a_CPS_administrator();
		when().Admin_update_program_level(CODE);
		then().program_level_is_updated();
	
}
}
