package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenStudentCourseInfoIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIViewStudentCourseInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

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
@As("As an academic administrator, I want to view course info so that I know course info is current")
@Submodule("Profile")
@Issue("PAMA-12")
public class US_AD_PFL_2004 extends SpringScenarioTest<GivenIAmAdministrator, WhenIViewStudentCourseInfo, ThenStudentCourseInfoIsCurrent> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2004.class);

    
    
    private static final String FACULTY_CODE = "A01";
    
    private static final String FACULTY_CODE2 = "A10";
    


    @Test
    @Rollback
    public void scenarioCPS() {
    	String username  = "cps";
		String password  = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
        when().CPS_view_course_info_for_faculty_$(FACULTY_CODE);
        then().student_course_info_is_current();
    }
 
	@Test
	@Rollback
	public void scenarioMGSEB() {
		String username  = "mgseb";
		String password  = "abc123";
		given().i_am_a_$_administrator_in_current_academic_session(username, password);
		when().MGSEB_view_course_info_for_faculty_$(FACULTY_CODE2);
        then().student_course_info_is_current();
	}
}
