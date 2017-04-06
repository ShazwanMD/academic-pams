package my.edu.umk.pams.academic.term;

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
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheDetailsOfferedCoursesInfoIsCurrent;
import my.edu.umk.pams.academic.term.stage.WhenIViewTheDetailsOfOfferedCourses;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**
 * @author asyikin.mr and ziana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_TRM_1015 extends
		SpringScenarioTest<GivenIAmStudent, WhenIViewTheDetailsOfOfferedCourses, ThenTheDetailsOfferedCoursesInfoIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1015.class);

	private static final String PROGRAM_CODE = "A01/MASTER/0001";

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	@ProvidedScenarioState
	private String faculty = "A01";

	@Test
	@Rollback(true)
	public void scenario01() {
		given().I_am_a_student_in_current_academic_session();
		when().I_view_the_details_offered_courses_for_program_$(PROGRAM_CODE);
		then().the_details_offered_courses_info_is_current();

	}
}

