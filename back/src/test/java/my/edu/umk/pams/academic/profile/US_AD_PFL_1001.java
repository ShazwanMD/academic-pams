package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenMailingAddressUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMailingAddress;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to update my mailing address so that my address on file is current")
@Submodule("Profile")
@Issue("PAMA-1")
public class US_AD_PFL_1001 extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateMailingAddress, ThenMailingAddressUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1001.class);
    
    @Test
    @Rollback
    public void mailing_address_update_success() {
        given().I_am_a_student_in_current_academic_session();
        when()
//        		.I_update_mailing_address()
//        		.and().I_review_mailing_address()
//        		.and()
        		.test_countryCode();
//        then().mailing_address_updated();
    }
}
