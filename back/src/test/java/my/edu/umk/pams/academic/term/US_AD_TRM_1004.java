package my.edu.umk.pams.academic.term;
/**
 * @author asyikin.mr
 */
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
import my.edu.umk.pams.academic.term.stage.ThenTheSectionsHaveAppointedStaff;
import my.edu.umk.pams.academic.term.stage.WhenIAppointStaffToSections;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_TRM_1004 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAppointStaffToSections, ThenTheSectionsHaveAppointedStaff> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1004.class);
	public static final String PROGRAM_CODE = "FKP/MASTER/0001";

	@Test
	@Rollback(true)
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_program_$(PROGRAM_CODE);
		when().I_appoint_staff_for_sections();
		then().the_sections_have_appointed_staff();
	}
}
