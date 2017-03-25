package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenInformationUpdated;
import my.edu.umk.pams.academic.profile.stage.WhenIWantUpdateCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As a student
 * I want to update course
 * so that information updated
 *
 * @author PAMS
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_1005 extends SpringScenarioTest<GivenIAmStudent, WhenIWantUpdateCourse, ThenInformationUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1005.class);

    @Test
    @Rollback(true)
    public void scenario1005() {
        given().I_am_a_student_in_current_academic_session();
        when().I_update_course_to_faculty_code_$a("26");
        then().Information_updated();
    }

}
