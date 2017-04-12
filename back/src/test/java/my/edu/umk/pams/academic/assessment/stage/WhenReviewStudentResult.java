package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenReviewStudentResult extends Stage<WhenReviewStudentResult>{

	@Pending
	public WhenReviewStudentResult I_review_result() {

		return self();
	}

}
