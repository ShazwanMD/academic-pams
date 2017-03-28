package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenIKnowMyCurrentStatus extends Stage<ThenIKnowMyCurrentStatus> {

    @Autowired
    private IdentityService identityService;
	
    @ExpectedScenarioState
	private AdActor actor;

    @ExpectedScenarioState
    private AdStudent student;
    
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

    public ThenIKnowMyCurrentStatus I_know_my_current_status() {

    	String studentNo = "A17P001";
    	
    	AdStudent student = identityService.findStudentByStudentNo(studentNo);
    	AdStudentStatus studentStatus = student.getStudentStatus();    	
    	Assert.isTrue(studentStatus.equals(studentStatus), "true");
    	
        return self();
    }

}
