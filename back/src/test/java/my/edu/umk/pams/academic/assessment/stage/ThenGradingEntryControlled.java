package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenGradingEntryControlled extends Stage<ThenGradingEntryControlled>{

	@Pending
	public ThenGradingEntryControlled grading_entry_interval_is_controlled() {
		
		return self();
	}

}
