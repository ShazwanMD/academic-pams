package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramLevelIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddProgramLevel;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As an admin academic,
 *  I Set Up Level Of Sudy For Faculty
 *   New Level Of Study Is Introduced
 * @author ain
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PNR_1008 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddProgramLevel, ThenProgramLevelIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1008.class);

    private String FACULTY_CODE = "FIAT";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "FIAT/PHD/0001";

    @Test
    @Rollback(false)
    public void scenario1008() {
        given().I_am_a_CPS_administrator();
        when().I_add_a_program_level_for_faculty_$(FACULTY_CODE);
        then().program_level_$_introduced(PROGRAM_CODE);
    }
}