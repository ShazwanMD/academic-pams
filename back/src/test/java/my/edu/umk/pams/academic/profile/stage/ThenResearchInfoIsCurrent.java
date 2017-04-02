package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenResearchInfoIsCurrent extends Stage<ThenResearchInfoIsCurrent> {
	
	
	@Pending
	public ThenResearchInfoIsCurrent Research_info_is_current(){
		
		
		return self();
	}

}
