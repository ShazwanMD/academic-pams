package my.edu.umk.pams.academic.planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCreditHasBeUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenAdminUpdateCredit;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator,i want to update credit  for a faculty so that the credit for each courses has be updated")
@Issue("")
@Submodule("Planner")

public class US_AD_PNR_1015 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminUpdateCredit, ThenCreditHasBeUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1015.class);
	private static final String FACULTY_CODE = "A10";
	public String COURSE_CODE = "GST5013";
	
	
	@Test
	@Rollback
	public void scenario1() {
		given().I_am_a_CPS_administrator()
		.and().I_pick_faculty_$(FACULTY_CODE);;
		when().Admin_update_credit_hour_for_$(COURSE_CODE);
		then().Credit_has_be_updated();


	}
}