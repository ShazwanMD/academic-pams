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
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateProgram;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PNR_1012
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateProgram, ThenProgramUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1012.class);

	public static final String FACULTY_CODE = "FKP";

	@ProvidedScenarioState
	private String PROGRAM_CODE = "FKP/MASTER/0010";

	@Test
	@Rollback(false)
	public void scenario1() {

		given().I_am_a_CPS_administrator().I_pick_program_$(PROGRAM_CODE);
		when().Admin_update_program_for_faculty_$(FACULTY_CODE);
		then().program_is_updated();
	}
}
