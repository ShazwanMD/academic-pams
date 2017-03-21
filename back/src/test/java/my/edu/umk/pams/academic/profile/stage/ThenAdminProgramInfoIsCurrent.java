package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class ThenAdminProgramInfoIsCurrent extends Stage<ThenAdminProgramInfoIsCurrent> {

	
	   @Autowired
	    private ProfileService profileService;

	    @ExpectedScenarioState
	    AdStudent student;

	    public ThenAdminProgramInfoIsCurrent program_info_is_current() {
	     
	        return self();
	    }
}
