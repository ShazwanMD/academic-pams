package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenExamVivaInfoViewed extends Stage<ThenExamVivaInfoViewed>  {

	@Pending
	public ThenExamVivaInfoViewed viva_info_viewed() {

		return self();
	}
	
	@Pending
	public ThenExamVivaInfoViewed exam_info_viewed() {

		return self();
	}

	
}
