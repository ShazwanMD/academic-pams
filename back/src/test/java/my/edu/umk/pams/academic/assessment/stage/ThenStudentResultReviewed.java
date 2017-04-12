package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenStudentResultReviewed extends Stage<ThenStudentResultReviewed > {

	
	@Pending
	public ThenStudentResultReviewed result_student_reviewed() {

		return self();
	}

}
