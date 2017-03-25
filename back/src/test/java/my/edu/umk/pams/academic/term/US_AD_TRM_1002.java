package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheStatusIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIUpdateAcademicSessionStatus;
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
 * @author asyikin.mr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_TRM_1002 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateAcademicSessionStatus, ThenTheStatusIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1002.class);

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_academic_session();
        when().I_update_academic_session_status();
        then().the_status_is_updated();
    }
}
