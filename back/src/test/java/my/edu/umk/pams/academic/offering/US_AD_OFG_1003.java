package my.edu.umk.pams.academic.offering;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.offering.stage.ThenTheStudentCanEnrol;
import my.edu.umk.pams.academic.offering.stage.WhenICreateSections;
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
 * @author asyikin.mr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_OFG_1003 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenICreateSections, ThenTheStudentCanEnrol> {
	 private static final Logger LOG = LoggerFactory.getLogger(US_AD_OFG_1003.class);
	 
	 
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
	        when().I_create_sections();
            then().the_student_can_enrol();
}
}
