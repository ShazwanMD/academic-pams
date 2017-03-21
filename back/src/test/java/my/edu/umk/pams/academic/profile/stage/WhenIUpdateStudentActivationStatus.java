package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.annotation.Pending;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class WhenIUpdateStudentActivationStatus extends Stage<WhenIUpdateStudentActivationStatus>{

	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateMyBillingAddress.class);

	@Autowired
	private ProfileService profileService;

	@Autowired
	private IdentityService identityService;
	
	@ProvidedScenarioState
	private AdStudent student;
	
	@Pending
	public WhenIUpdateStudentActivationStatus I_update_student_activation_status() {
		
		//todo
		
		return self();
	}	
	
	}


