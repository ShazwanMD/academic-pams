package my.edu.umk.pams.academic.studyplan;


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
import my.edu.umk.pams.academic.studyplan.stage.ThenICanPlanWhatToManageScheduleDetail;
import my.edu.umk.pams.academic.studyplan.stage.WhenIWantToViewTheCourseForMyProgram;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**
 * As a student,
 * i want to view the course for my program
 * so that I can plan what to manage schedule detail.
 *
 * @author zaida
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_SPL_2003 extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewTheCourseForMyProgram, ThenICanPlanWhatToManageScheduleDetail> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_2003.class);

    private static final String FACULTY_CODE = "FKP";

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario2003() {
        given().I_am_a_student_in_current_academic_session();
        when().I_want_to_view_the_course_for_faculty_$(FACULTY_CODE);
        then().I_can_plan_what_to_manage_schedule_detail();
    }
}
