package my.edu.umk.pams.academic.profile.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenStudentBarringStatusReviewed extends Stage<ThenStudentBarringStatusReviewed> {

	@Pending
	public ThenStudentBarringStatusReviewed I_know_student_barring_status(){
    	
        return self();

	}
}
