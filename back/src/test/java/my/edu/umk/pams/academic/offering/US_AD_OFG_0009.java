package my.edu.umk.pams.academic.offering;
/**
 * @author ziana
 */
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
import my.edu.umk.pams.academic.offering.stage.ThenICanChoose;
import my.edu.umk.pams.academic.offering.stage.WhenIWantToViewTheOfferedCoursesByAcademicSession;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_OFG_0009 extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewTheOfferedCoursesByAcademicSession, ThenICanChoose> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_OFG_0009.class);
	

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_student_in_current_academic_session();
        when().I_want_to_view_the_offered_courses_by_academic_session();
        then().i_can_choose();
    }
}
