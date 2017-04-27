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
import my.edu.umk.pams.academic.term.stage.ThenTheChargeScheduleIsNoticed;
import my.edu.umk.pams.academic.term.stage.WhenIViewChargeSchedule;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student in current academic session, i can view the charge schedule before make an enrollment, so that the extra charge payment will be noticed")
@Submodule("Term")
public class US_AD_TRM_1029 extends
SpringScenarioTest<GivenIAmStudent, WhenIViewChargeSchedule, ThenTheChargeScheduleIsNoticed> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1029.class);
	public static final String PROGRAM_CODE = "FIAT/MASTER/MBT";
	private static final String COHORT_CODE = "FIAT/MASTER/MBT/CHRT/201720181";
	
	@Test
	@Rollback(true)
	public void studentReviewChargeSchedule() {
		given().I_am_a_student_in_current_academic_session().and().I_pick_program_$(PROGRAM_CODE);
		when().I_add_charge_schedule_for_cohort_$(COHORT_CODE).and().when().I_view_charge_schedule_for_cohort_$(COHORT_CODE);
		then().the_charge_schedule_is_noticed();
	}

}
