package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenMyBillingAddressUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMyBillingAddress;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**
 * As a student I want to update my billing address so that my address on file
 * is current
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_1002 extends SpringScenarioTest<GivenIAmStudent, WhenIUpdateMyBillingAddress, ThenMyBillingAddressUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1002.class);

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
		when().I_add_my_billing_address().and().when().I_update_my_billing_address();
		then().my_billing_address_on_file_is_current();
	}
}
