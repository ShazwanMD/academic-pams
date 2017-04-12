
package my.edu.umk.pams.academic.planner;

import org.junit.Test;
/**
 * As an admin academic,,

 *   I want to up date new academic semester info,
 *      so that the new academic semester info is created
 * @author ain
 */

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenAcademicSessionUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenIUpdateAcademicSession;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to update new academic session info so that the new academic session info is updated")
@Issue("PAMA-47")
public class US_AD_PNR_1011
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateAcademicSession, ThenAcademicSessionUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1011.class);

	@Test
	@Rollback(false)
	public void UpdateAcademicSession() {

		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().I_update_academic_session();
		then().the_academic_session_is_updated();
	}

}
