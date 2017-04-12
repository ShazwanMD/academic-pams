package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenProgramInfoIsUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIAddProgramInfo;
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
@As("As an academic administrator, I want to update program information so that program info is current")
@Submodule("Profile")
@Issue("PAMA-14")
public class US_AD_PFL_2006
        extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddProgramInfo, ThenProgramInfoIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2006.class);
    private String FACULTY_CODE = "A01";

    @Test
    @Rollback
    public void scenario2006() {
        given().I_am_a_CPS_administrator_in_current_academic_session();
        when().I_add_program_info_$(FACULTY_CODE).and().when().I_view_program_info_$(FACULTY_CODE);
        then().the_program_is_current_for_$(FACULTY_CODE);
    }
}
