package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenProgramLevelIntroduced;
import my.edu.umk.pams.academic.studyplan.stage.WhenIAddProgramLevel;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
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

/**
 * As an admin academic,
 * i want set up level of study for a faculty,
 * so that a new level of study is introduced
 *
 * @author ain
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_SPL_1008 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIAddProgramLevel, ThenProgramLevelIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_1008.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    private String FACULTY_CODE = "FKP";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "MASTER";

    @Test
    @Rollback(true)
    public void scenario1008() {
        given().I_am_a_PPS_administrator();
        when().I_add_a_program_level_for_faculty_$(FACULTY_CODE);
        then().program_level_$_introduced(PROGRAM_CODE);
    }
}