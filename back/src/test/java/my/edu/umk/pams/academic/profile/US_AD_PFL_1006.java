package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenInformationIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenReviewCourseInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to view course info so that information is current")
@Submodule("Profile")
@Issue("PAMA-6")
public class US_AD_PFL_1006 extends SpringScenarioTest<GivenIAmStudent, WhenReviewCourseInfo, ThenInformationIsCurrent> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1006.class);
    
    
    private static final String FACULTY_CODE = "A10";

    @Test
    @Rollback
    public void scenario1006() {
        given().I_am_a_student_in_current_academic_session();
        when().I_view_course_info_for_faculty_$(FACULTY_CODE);
        then().course_info_is_current();
    }

}
