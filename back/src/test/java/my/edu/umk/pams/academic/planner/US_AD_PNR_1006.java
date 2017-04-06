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
import my.edu.umk.pams.academic.planner.stage.ThenCurriculumHasAdded;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCurriculum;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

/*
 *I Am Admin
 *Admin Add Curriculum 
 *Curriculum Has Added
 * @author zaida_AIN
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PNR_1006 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddCurriculum, ThenCurriculumHasAdded>{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1006.class);

	private static final String PROGRAM_CODE = "A10";

	
	@Test
	@Rollback(true)
	public void scenario1006() {
		given().I_am_a_CPS_administrator()
			.and().I_pick_program_$(PROGRAM_CODE);
		when().Admin_add_curriculum();
		then().Curriculum_has_added();
		
	}
}
