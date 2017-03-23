package my.edu.umk.pams.academic.offering;

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

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.offering.stage.ThenTheStatusOfAppointmentIsUpdated;
import my.edu.umk.pams.academic.offering.stage.WhenIUpdateAppointmentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;

/**
 * @author asyikin.mr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_OFG_1006 extends
        SpringScenarioTest<GivenIAmPPSAdministrator, WhenIUpdateAppointmentStatus, ThenTheStatusOfAppointmentIsUpdated> {
    private static final Logger LOG = LoggerFactory.getLogger(US_AD_OFG_1006.class);


    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_PPS_administrator_in_current_academic_session().and()
                .I_pick_offering_$("");
        when().I_appoint_a_staff_$_into_all_section_for_the_offering("01001A");
        then().the_number_of_appointed_staff_increased();
    }
}
