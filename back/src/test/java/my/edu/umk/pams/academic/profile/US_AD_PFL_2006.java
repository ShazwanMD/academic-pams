package my.edu.umk.pams.academic.profile;

import org.junit.After;
import org.junit.Before;
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
import my.edu.umk.pams.academic.profile.stage.ThenAdminProgramInfoIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIWantToAddProgramInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

/**
 * 
 * 
 * As an admin, I want to update program information, so that program info is
 * current
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_2006
		extends SpringScenarioTest<GivenIAmAdministrator, WhenIWantToAddProgramInfo, ThenAdminProgramInfoIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2006.class);

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	private String FACULTY_CODE = "FKP";
	@ProvidedScenarioState
	private String PROGRAM_CODE = "PRGM-101";

	@Test
	@Rollback(false)
	public void scenario01() {
		given().I_am_a_PPS_administrator_in_current_academic_session();
		when().I_add_program_info_$(FACULTY_CODE);
		then().the_program_is_current_for_$(FACULTY_CODE);
	}
}
