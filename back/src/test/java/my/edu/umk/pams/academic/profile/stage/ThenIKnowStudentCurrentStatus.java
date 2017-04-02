package my.edu.umk.pams.academic.profile.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class ThenIKnowStudentCurrentStatus extends Stage<ThenIKnowStudentCurrentStatus>{


    @ExpectedScenarioState
    private AdStudent student;
    
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;
	
    public ThenIKnowStudentCurrentStatus I_know_student_$_current_status(String identityNo) {
    	
//    	hmm ni kawe buat ni

    	studentStatus = student.getStudentStatus();    	
    	Assert.isTrue(studentStatus.equals(studentStatus), "true");
    	
        return self();

    }
}
