package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenBillingAddressUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateBillingAddress;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to update my billing address so that my address on file is current")
public class US_AD_PFL_1002
		extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateBillingAddress, ThenBillingAddressUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1002.class);

	@Test
	@Rollback
	public void scenario1002() {
		given().I_am_a_student_in_current_academic_session();
		when().I_add_my_billing_address().and().when().I_update_billing_address();
		then().Billing_address_updated();
	}
}
