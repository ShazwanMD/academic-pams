package my.edu.umk.pams.academic.term;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author asyikin.mr and ziana
 */
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentDateIsOpen;
import my.edu.umk.pams.academic.term.stage.WhenIOpenTheEnrollmentDate;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Pending
public class US_AD_TRM_1011 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIOpenTheEnrollmentDate,ThenTheEnrollmentDateIsOpen> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1011.class);
	private static final String PROGRAM_CODE = "FKP/PHD/0001";
	
	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	@Test
	@Rollback(true)
	public void scenario01() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_open_the_date_of_enrollment_for_program_$(PROGRAM_CODE);
		then().the_enrollment_date_is_open();

	}

}

