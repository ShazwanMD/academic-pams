package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenViewStudentResult extends Stage<WhenViewStudentResult> {
	
	@Pending
	public WhenViewStudentResult supervisor_review_student_result() {

		return self();
	}

}
