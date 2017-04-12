package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIReviewExamVivaInfo extends Stage<WhenIReviewExamVivaInfo> {

	
	@Pending
	public WhenIReviewExamVivaInfo i_review_examination_info() {
		
		
		return self();
		
	}

	@Pending
	public WhenIReviewExamVivaInfo i_review_viva_info() {


		return self();
		
	}

}
