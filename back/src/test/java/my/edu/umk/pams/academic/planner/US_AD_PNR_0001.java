package my.edu.umk.pams.academic.planner;
/*
 * @author zaida
 */

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenGradePointCalculated;
import my.edu.umk.pams.academic.planner.stage.WhenAggregateAllSessions;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;
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
@As("As staff, I want to access all grade points so that I can calculate cumulative grade points")
@Submodule("Planner")

public class US_AD_PNR_0001
		extends SpringScenarioTest<GivenIAmAcademicStaff, WhenAggregateAllSessions, ThenGradePointCalculated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_0001.class);

	@Test
	@Rollback
	public void scenario001() throws Exception {
		given().i_am_a_staff_in_current_academic_session(); // no effect
		when().I_gather_aggregate_applications();
		then().grade_point_is_calculated();
	}
}

