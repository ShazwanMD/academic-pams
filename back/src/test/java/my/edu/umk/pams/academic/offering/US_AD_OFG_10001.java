package my.edu.umk.pams.academic.offering;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.offering.stage.ThenTheOfferingIsReadyForSetup;
import my.edu.umk.pams.academic.offering.stage.WhenIOfferACourse;
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
 * example
 *
 * @author asyikin and ziana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_OFG_10001
        extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIOfferACourse, ThenTheOfferingIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_OFG_10001.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_PPS_administrator_in_current_academic_session();
        when().I_offer_all_courses_under_program_faculty();
        then().the_offering_is_ready_for_setup();
    }
}
