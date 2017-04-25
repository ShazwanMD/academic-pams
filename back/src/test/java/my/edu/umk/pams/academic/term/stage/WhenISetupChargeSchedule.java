package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenISetupChargeSchedule extends Stage<WhenISetupChargeSchedule> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenISetupChargeSchedule.class);
	
	public WhenISetupChargeSchedule I_setup_charge_schedule_for_cohort_$(String code) {

		//process setup charge schedule in table ad_chrg_scdl by admin
		
		return self();
	}
}