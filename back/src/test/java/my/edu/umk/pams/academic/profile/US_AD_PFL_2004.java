package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenStudentCourseInfoIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIViewStudentCourseInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As an admin,
 * I want to view course info,
 * so that course info is current
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_2004 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIViewStudentCourseInfo, ThenStudentCourseInfoIsCurrent> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2004.class);

    private static final String FACULTY_CODE = "A01";

    @Test
    @Rollback
    public void scenario2004() {
        given().I_am_a_CPS_administrator_in_current_academic_session();
        when().I_view_student_course_info_for_faculty_$(FACULTY_CODE);
        then().student_course_info_is_current();
    }
}
