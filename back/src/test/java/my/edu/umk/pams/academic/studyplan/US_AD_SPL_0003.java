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
import my.edu.umk.pams.academic.studyplan.stage.ThenCoursesUpdated;
import my.edu.umk.pams.academic.studyplan.stage.ThenFacultyHasCourse;
import my.edu.umk.pams.academic.studyplan.stage.WhenIAddACourse;
import my.edu.umk.pams.academic.studyplan.stage.WhenIUpdateCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;

/*As an admin academic, 
i can update courses for a faculty, 
so that its information of new course for each programmes is updated 

@author PAMS - Rodziah Mohamad Nor
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_SPL_0003 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIUpdateCourses, ThenCoursesUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_0003.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }
	
    @Test
    @Rollback(true)
    public void scenario1 () {
        given().I_am_a_PPS_administrator();
        when().I_update_courses_to_faculty_code_$a("45");
        then().new_courses_information_updated();
    }
}
