package my.edu.umk.pams.academic.assessment.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class WhenSetupGradingEntryInterval extends Stage<WhenSetupGradingEntryInterval> {

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private ProfileService profileService;
	
	@Pending
	public WhenSetupGradingEntryInterval I_setup_grading_entry_interval() {

		
		
		return self();
	}

}
