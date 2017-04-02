package my.edu.umk.pams.academic.profile.stage;



import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;



@JGivenStage
public class ThenStudentGraduationStatusReviewed extends Stage<ThenStudentGraduationStatusReviewed> {

    @ExpectedScenarioState
    private AdStudent student;
    
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	public ThenStudentGraduationStatusReviewed student_graduation_status_reviewed() {
		
		student.getIdentityNo();
    	
    	AdStudentStatus expectedStatus = student.getStudentStatus();
    	AdStudentStatus actualStatus = student.getStudentStatus();
    	
    	Assert.isTrue(expectedStatus.equals(actualStatus), "exists");
		
		
		return self();
		
	}

}
