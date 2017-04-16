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
import my.edu.umk.pams.academic.planner.stage.ThenNewCurriculumIsUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCurriculum;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateCurriculum;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to update curriculum for a faculty so that curriculum has updated")
@Issue("PAMA-49")
@Submodule("Planner")

public class US_AD_PNR_1011
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateCurriculum, ThenNewCurriculumIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1011.class);

	@ProvidedScenarioState
	private String CODE = "A07/PHD/0002/CRLM/0001";

	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator();
		when().Admin_update_curriculum_$(CODE);
		then().new_curriculum_is_updated();

	}
}


