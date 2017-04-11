package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheAdvisorInfoIsCurrent extends Stage<ThenTheAdvisorInfoIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdvisorInfoIsCurrent.class);
	
	public ThenTheAdvisorInfoIsCurrent The_advisor_info_is_current() {
		
		// view advisor info details from table ad_actr 
		
		return self();

	}

}