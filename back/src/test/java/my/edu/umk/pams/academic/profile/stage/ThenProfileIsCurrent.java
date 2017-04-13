package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenProfileIsCurrent extends Stage<ThenProfileIsCurrent> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenProfileIsCurrent.class);

	public ThenProfileIsCurrent profile_current() {
		
		return self();
		
	}

}
