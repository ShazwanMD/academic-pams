package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;

@JGivenStage
public class ThenStudentProfileReviewed extends Stage<ThenStudentProfileReviewed> {

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	List<AdAddress> address;
	
	
	public ThenStudentProfileReviewed student_profile_reviewed() {

		Assert.isTrue(student.equals(student), "missing");
		
		
		return self();
		
	}

}
