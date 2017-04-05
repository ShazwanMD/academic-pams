package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCoursesUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*Given : I Am Admin
When : Admin Update Courses
Then :  New courses Is Updated.
@author PAMS - Rodziah Mohamad Nor
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PNR_1003 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateCourses, ThenCoursesUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1003.class);

    // refer to data/AD_FCTY.sql
    public static final String FACULTY_CODE = "A01";
    
    public static final String COURSE_CODE = "DDA2113";

    @Test
    @Rollback(false)
    public void scenario1() {
        given().I_am_a_CPS_administrator().and().I_pick_course_$(COURSE_CODE);
        when().Admin_update_courses_to_faculty_code_$a(FACULTY_CODE);
        then().new_courses_information_updated();
    }
}
