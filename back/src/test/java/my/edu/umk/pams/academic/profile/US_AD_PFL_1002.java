package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenBillingAddressUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateBillingAddress;
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
@As("As a student, I want to update my billing address so that my address on file is current")
@Submodule("Profile")
@Issue("PAMA-2")
public class US_AD_PFL_1002 extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateBillingAddress, ThenBillingAddressUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1002.class);
	
	@ProvidedScenarioState
	private static String matricNo = "A17M0009F";

	@Test
	@Rollback
	public void scenario1002() {
		given().I_am_a_student_in_current_academic_session();
		when().I_update_billing_address()
				.and().I_review_address();
		then().Billing_address_updated();
	}
}
