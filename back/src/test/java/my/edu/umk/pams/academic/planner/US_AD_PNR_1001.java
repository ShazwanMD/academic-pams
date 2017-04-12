package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramIsIntroduced;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddAProgram;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;

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
@As("As an academic administrator, i want to set program for a faculty so that a new program is introduced")
@Issue("PAMA-18")
public class US_AD_PNR_1001 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddAProgram, ThenProgramIsIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1001.class);

    private String FACULTY_CODE = "A01";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "PRGM-1234";

    @Test
    @Rollback
    public void AddProgram() {
        given().I_am_a_CPS_administrator();
        when().Admin_add_a_program_for_faculty_$(FACULTY_CODE);
        then().the_program_$_is_introduced_for_faculty_$(PROGRAM_CODE, FACULTY_CODE);
    }
}
