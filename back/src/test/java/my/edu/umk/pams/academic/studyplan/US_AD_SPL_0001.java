package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenProgramIsIntroduced;
import my.edu.umk.pams.academic.studyplan.stage.WhenIAddAProgram;
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
 *  U want to set up a program for a faculty
 *      so that a new program is introduced
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_SPL_0001 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIAddAProgram, ThenProgramIsIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_0001.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    private String FACULTY_CODE = "FKP";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "PRGM-1234";

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_PPS_administrator();
        when().I_add_a_program_for_faculty_$(FACULTY_CODE);
        then().the_program_$_is_introduced_for_faculty_$(PROGRAM_CODE, FACULTY_CODE);
    }
}
