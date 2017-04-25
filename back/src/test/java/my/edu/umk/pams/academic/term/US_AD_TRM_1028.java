package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.term.stage.ThenTheChargeScheduleIsReviewed;
import my.edu.umk.pams.academic.term.stage.WhenISetupChargeSchedule;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic admininistrator, I want to setup charge schedule for cohort under selected program and faculty, so that the charge schedule is reviewed.")
@Submodule("Term")
public class US_AD_TRM_1028 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenISetupChargeSchedule, ThenTheChargeScheduleIsReviewed> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1028.class);
	public static final String FACULTY_CODE = "A07";
	public static final String PROGRAM_CODE = "FIAT/PHD/PBT";
	private static final String COHORT_CODE = "FIAT/PHD/PBT/CHRT/201720181";

	@Test
	@Rollback(true)
	public void adminSetupChargeSchedule() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_faculty_$(FACULTY_CODE).and()
		.I_pick_program_$(PROGRAM_CODE);
		when().I_setup_charge_schedule_for_cohort_$(COHORT_CODE);
		then().the_charge_schedule_is_reviewed();
	}

}
