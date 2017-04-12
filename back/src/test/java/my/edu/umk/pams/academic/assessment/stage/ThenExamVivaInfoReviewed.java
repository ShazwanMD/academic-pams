package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenExamVivaInfoReviewed extends Stage<ThenExamVivaInfoReviewed> {

	
	@Pending
	public ThenExamVivaInfoReviewed exam_info_reviewed() {
		
		
		return self();
		
	}

	
	@Pending
	public ThenExamVivaInfoReviewed viva_info_reviewed() {
	
		
		return self();
	}

}
