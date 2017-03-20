package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;


/**
 * @author PAMS
 */

@JGivenStage
public class ThenCurrentStudentProfileInfoIsUpdated extends Stage<ThenCurrentStudentProfileInfoIsUpdated> {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private IdentityService identityService;
	
	@ExpectedScenarioState
	AdStudent student;

	
	@ExpectedScenarioState
	AdActor actor;
	
	public ThenCurrentStudentProfileInfoIsUpdated current_student_profile_info_is_updated() {
		AdActor actor = identityService.findActorByIdentityNo("760607145591");
		
		
	
		
	

		return self();

	}

}
