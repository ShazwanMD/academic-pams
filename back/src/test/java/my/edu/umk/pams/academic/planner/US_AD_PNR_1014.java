package my.edu.umk.pams.academic.planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCreditHoursApplied;
import my.edu.umk.pams.academic.planner.stage.WhenEnterCreditHours;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator,i want to set credit  for a faculty so that the credit for each courses introduced")
@Issue("PAMA-45")
@Submodule("Planner")

public class US_AD_PNR_1014 extends
SpringScenarioTest<GivenIAmCPSAdministrator, WhenEnterCreditHours, ThenCreditHoursApplied>{
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1014.class);
	private static final String FACULTY_CODE = "A01";
	private static final Integer COURSE_CREDIT = 3;

	@Test
	@Rollback(false)
	public void scenario1() {
		given().I_am_a_CPS_administrator()
		.and().I_pick_faculty_$(FACULTY_CODE);
		when().I_set_course_credit_hours(COURSE_CREDIT);
		then().course_credit_hours_are_applied(COURSE_CREDIT);
}
}


