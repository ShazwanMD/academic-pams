package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenStudentResearchTitleUpdatedByAdmin;
import my.edu.umk.pams.academic.profile.stage.WhenAdminUpdateStudentResearchTitle;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

/*As an admin, 
	I want to update student research title, 
	so that research title is current
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_2005 extends SpringScenarioTest<GivenIAmAdministrator, WhenAdminUpdateStudentResearchTitle, ThenStudentResearchTitleUpdatedByAdmin> {

	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2005.class);
	
	
	
	@Test
	@Rollback
	public void scenarioCPS(){
		
		given().i_am_a_$_administrator_in_current_academic_session("cps", "abc123");
		when().Admin_update_student_research_title();
		then().Student_research_title_updated_by_admin_cps();
		
	}

	@Test
	@Rollback
	public void scenarioMGSEB(){
		
		given().i_am_a_$_administrator_in_current_academic_session("mgseb", "abc123");
		when().Admin_update_student_research_titles();
		then().Student_research_title_updated_by_admin_mgseb();
		
	}
}
