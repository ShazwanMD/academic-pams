package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenMyAddressUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMyMailingAddress;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
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
 * As a student
 *  I want to update my billing address
 *  and I want to update my mailing address
 *      so that my address on file is current
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_0001 extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateMyMailingAddress, ThenMyAddressUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_0001.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario01() {
        given().I_am_a_student_in_current_academic_session();
        when().I_update_my_mailing_address();
        then().my_address_on_file_is_current();
    }
}
