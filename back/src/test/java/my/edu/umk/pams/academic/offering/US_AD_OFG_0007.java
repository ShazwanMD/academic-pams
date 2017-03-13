package my.edu.umk.pams.academic.offering;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.offering.stage.ThenTheOfferedCourseHasAMaxAllowQuota;
import my.edu.umk.pams.academic.offering.stage.WhenIWantToSetCapacityForOfferedCourse;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
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

/**
 * @author asyikin.mr and ziana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_OFG_0007 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIWantToSetCapacityForOfferedCourse, ThenTheOfferedCourseHasAMaxAllowQuota> {

	 private static final Logger LOG = LoggerFactory.getLogger(US_AD_OFG_0007.class);

	    @Before
	    public void before() {
	    }

	    @After
	    public void after() {
	    }

	    @Test
	    @Rollback(true)
	    public void scenario1() {
	        given().I_am_a_PPS_administrator_in_current_academic_session();
	        when().I_set_offering_capacity();
	        then().the_offered_course_has_a_maximum_quota();
	    }
	}
