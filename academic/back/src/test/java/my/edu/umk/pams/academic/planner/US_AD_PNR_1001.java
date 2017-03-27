package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramIsIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenIAddAProgram;
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
 * U want to set up a program for a faculty
 * so that a new program is introduced
 *
 * @author zaida_ain
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PNR_1001 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddAProgram, ThenProgramIsIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1001.class);

    private String FACULTY_CODE = "FKP";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "PRGM-1234";

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator();
        when().I_add_a_program_for_faculty_$(FACULTY_CODE);
        then().the_program_$_is_introduced_for_faculty_$(PROGRAM_CODE, FACULTY_CODE);
    }
}
