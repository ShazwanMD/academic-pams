package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenActivationStatusReviewed extends Stage<ThenActivationStatusReviewed> {

    @Autowired
    private IdentityService identityService;
	
    @ExpectedScenarioState
    private AdStudent student;
   
	
    public ThenActivationStatusReviewed activation_status_reviewed() {

    	student.getIdentityNo();
    	
    	AdStudentStatus expectedStatus = student.getStudentStatus();
    	AdStudentStatus actualStatus = student.getStudentStatus();
    	
    	Assert.isTrue(expectedStatus.equals(actualStatus), "exists");
    	
        return self();
    }

}
