package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenIKnowTheEnrollmentIntervalPeriod extends Stage<ThenIKnowTheEnrollmentIntervalPeriod> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenIKnowTheEnrollmentIntervalPeriod.class);
	
	public ThenIKnowTheEnrollmentIntervalPeriod i_know_the_enrollment_interval_period() {
		return self();
		
	}
}

