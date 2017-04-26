package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheChargeScheduleIsNoticed extends Stage<ThenTheChargeScheduleIsNoticed> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheChargeScheduleIsNoticed.class);
	
	public ThenTheChargeScheduleIsNoticed the_charge_schedule_is_noticed() {

		// process view charge schedule in db
		
		return self();
	}
}
