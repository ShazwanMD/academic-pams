package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenMyContactNumberIsUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMyContactNumber;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*As a student, 
 * I want to update my contact number, 
 * so that my contact number on file is current
 */


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PFL_1004 extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateMyContactNumber, ThenMyContactNumberIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1004.class);

    @Test
    @Rollback
    public void scenario1004() {
        given().I_am_a_student_in_current_academic_session();
        when().I_add_my_contact_number().and().when().I_update_my_contact_number();
        then().my_contact_number_is_updated();
    }
}