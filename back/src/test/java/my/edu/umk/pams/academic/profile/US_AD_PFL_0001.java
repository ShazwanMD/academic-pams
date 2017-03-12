package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.profile.stage.ThenMyAddressUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMyBillingAddress;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMyMailingAddress;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**
 * As a student
 *  I want to update my billing address
 *  and I want to update my mailing address
 *      so that my address on file is current
 *
 * @author PAMS
 */


public class US_AD_PFL_0001 extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateMyMailingAddress, ThenMyAddressUpdated> {

    @ScenarioStage
    private WhenIUpdateMyBillingAddress additionalState;

    public void testScenario01() {
        given().I_am_a_student_in_current_academic_session();
        when().I_update_my_home_address();
        additionalState.and().I_update_my_billing_address();
        then().my_address_on_file_is_current();

    }
}
