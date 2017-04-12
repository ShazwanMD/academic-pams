package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIAmReviewStudentInfo extends Stage<WhenIAmReviewStudentInfo> {

	
	@Pending
	public WhenIAmReviewStudentInfo i_review_student_info() {
		
		return self();
		
	}

}
