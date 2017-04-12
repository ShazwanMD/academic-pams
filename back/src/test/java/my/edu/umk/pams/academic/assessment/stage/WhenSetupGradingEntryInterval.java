package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenSetupGradingEntryInterval extends Stage<WhenSetupGradingEntryInterval> {

	@Pending
	public WhenSetupGradingEntryInterval I_setup_grading_entry_interval() {

		return self();
	}

}
