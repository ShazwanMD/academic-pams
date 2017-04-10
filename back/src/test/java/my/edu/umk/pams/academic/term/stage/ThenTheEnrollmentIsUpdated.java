package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@Pending
@JGivenStage
public class ThenTheEnrollmentIsUpdated extends Stage<ThenTheEnrollmentIsUpdated> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentIsUpdated.class);

	public ThenTheEnrollmentIsUpdated the_enrollment_is_updated() {
		
		//transfer section is updated in ad_enmt
		
		return null;
		
	}
}



