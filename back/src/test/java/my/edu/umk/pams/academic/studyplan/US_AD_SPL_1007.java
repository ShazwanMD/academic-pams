package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenCourseHasPrerequisite;
import my.edu.umk.pams.academic.studyplan.stage.WhenIAddACoursePrerequisite;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
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

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 * @author ain_zaida
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_SPL_1007 extends SpringScenarioTest<GivenIAmAdministrator, WhenIAddACoursePrerequisite, ThenCourseHasPrerequisite> {

private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_1007.class);

	private static final String COURSE_CODE = "DDA2103";
	
    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(false)
    public void scenario1007() {
        given().I_am_a_PPS_administrator_in_current_academic_session();
        when().I_want_add_course_prerequisite_$("COURSE_CODE");
        then().Course_has_prerequisite();
    }

}
