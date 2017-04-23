package my.edu.umk.pams.academic.planner;
/**
 * @author zaida_nawi
 */
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.model.AdProgramType;
import my.edu.umk.pams.academic.planner.stage.ThenProgramLevelIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddProgramLevel;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want set up level of study for a faculty so that a new level of study is introduced")
@Issue("PAMA-25")
@Submodule("Planner")
public class US_AD_PNR_1004 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddProgramLevel, ThenProgramLevelIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1004.class);

    @ProvidedScenarioState
    private String FACULTY_CODE = "A07";

    @ProvidedScenarioState
    private AdProgramType programType = AdProgramType.MASTER;

    @Test
    @Rollback
    public void add_master_program_level() {
        given().I_am_a_CPS_administrator();
        when().i_add_a_program_level_post_graduate_for_faculty();
        then().program_level_post_graduate_introduced();
    }
}