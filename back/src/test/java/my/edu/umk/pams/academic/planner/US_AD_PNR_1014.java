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
import my.edu.umk.pams.academic.planner.stage.ThenNewCurriculumIsUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCurriculum;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateCurriculum;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

/*Given : I Am Admin
 * When : Admin Update Curriculum
 * Then :  New Curriculum Is Updated.

@author zaida_n
*/
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PNR_1014
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateCurriculum, ThenNewCurriculumIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1014.class);

	@ProvidedScenarioState
	private String PROGRAM_CODE = "FSB/PHD/0001/CRLM/0001";

	@Test
	@Rollback(false)
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().Admin_update_curriculum_$(PROGRAM_CODE);
		then().new_curriculum_is_updated();

	}
}


