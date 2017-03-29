package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenICanManageScheduleByProgram;
import my.edu.umk.pams.academic.planner.stage.WhenIWantToSetUpCurriculumForAFaculty;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*
 * As an admin academic, 
 * i want to set up curriculum for a faculty, 
 * so that i can manage schedule by program.
 * @author zaida
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PNR_1006 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIWantToSetUpCurriculumForAFaculty, ThenICanManageScheduleByProgram> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1006.class);

	private static final String PROGRAM_CODE = "FKP/MASTER/0001";

	@Test
	@Rollback
	public void scenario1006() {
		given().I_am_a_CPS_administrator()
			.and().I_pick_program_$(PROGRAM_CODE);
		when().I_set_up_curriculum_for_that_program();
		then().I_can_manage_schedule_by_program();
	}
}
