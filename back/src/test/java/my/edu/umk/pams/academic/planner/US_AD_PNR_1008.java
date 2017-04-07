package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.As;
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


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want set up level of study for a faculty so that a new level of study is introduced")
public class US_AD_PNR_1008 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddProgramLevel, ThenProgramLevelIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1008.class);
    private String FACULTY_CODE = "A07";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "A07/PHD/0009";

    @Test
    @Rollback
    public void scenario1008() {
        given().I_am_a_CPS_administrator();
        when().Admin_add_a_program_level_for_faculty_$(FACULTY_CODE);
        then().program_level_$_introduced(PROGRAM_CODE);
    }
}