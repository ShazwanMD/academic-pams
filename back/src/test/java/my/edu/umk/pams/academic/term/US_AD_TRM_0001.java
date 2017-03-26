package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheOfferingIsReadyForSetup;
import my.edu.umk.pams.academic.term.stage.WhenIOfferACourse;
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
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_TRM_0001 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIOfferACourse, ThenTheOfferingIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_0001.class);

    // from AD_PRGM.sql, doesn't have any offering or section
    public static final String PROGRAM_CODE = "FIAT/PHD/0001";

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_academic_session()
                .and().I_pick_program_$(PROGRAM_CODE);
        when().I_offer_all_courses_under_program_faculty();
        then().the_offering_is_ready_for_setup();
    }
}
