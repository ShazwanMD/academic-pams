package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenProgramInfoIsUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIAddProgramInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
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
@As("As an academic administrator, I want to update program information so that program info is current")
public class US_AD_PFL_2006
        extends SpringScenarioTest<GivenIAmAdministrator, WhenIAddProgramInfo, ThenProgramInfoIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2006.class);
    private String FACULTY_CODE = "A01";

    @Test
    @Rollback
    public void scenarioCPS() {
    	String username  = "cps";
    	String password  = "abc123";
        given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().I_add_program_info_$(FACULTY_CODE).and().when().I_view_program_info_$(FACULTY_CODE);
        then().the_program_is_current_for_$(FACULTY_CODE);
    }
    
    @Test
    @Rollback
    public void scenarioMGSEB() {
    	String username  = "mgseb";
    	String password  = "abc123";
        given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().I_add_program_info_$(FACULTY_CODE).and().when().I_view_program_info_$(FACULTY_CODE);
        then().the_program_is_current_for_$(FACULTY_CODE);
    }
}
