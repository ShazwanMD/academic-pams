package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.term.stage.ThenTheStatusOfAppointmentIsUpdated;
import my.edu.umk.pams.academic.term.stage.WhenIAppointStaffIntoSection;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

/**
 * @author asyikin.mr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_TRM_1006 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAppointStaffIntoSection, ThenTheStatusOfAppointmentIsUpdated> {
    private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1006.class);

    // from data/AD_ACTR.sql
    public static final String STAFF_NO = "01001A";
    // from data/AD_OFRG.sql
    public static final String SECTION_CANONICAL_CODE = "FKP/PHD/0001/DDA2113/201720181";

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_academic_session().and()
                .I_pick_section_$(SECTION_CANONICAL_CODE);
        when().I_appoint_a_staff_$_into_section(STAFF_NO);
        then().the_number_of_appointed_staff_increased();
    }
}
