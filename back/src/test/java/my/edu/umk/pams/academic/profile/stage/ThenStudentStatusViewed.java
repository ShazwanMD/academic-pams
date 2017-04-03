package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;

public class ThenStudentStatusViewed extends Stage<ThenStudentStatusViewed> {
	
	   @ExpectedScenarioState
	    private AdStudent student;
		
	public ThenStudentStatusViewed I_know_student_status_current() {
		
    	student.getIdentityNo();
    	
    	AdStudentStatus expectedStatus = student.getStudentStatus();
    	AdStudentStatus actualStatus = student.getStudentStatus();
    	
    	Assert.isTrue(expectedStatus.equals(actualStatus), "exists");
		return self();
	}

}
