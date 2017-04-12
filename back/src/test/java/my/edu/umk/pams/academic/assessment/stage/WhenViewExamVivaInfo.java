package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenViewExamVivaInfo extends Stage<WhenViewExamVivaInfo> {
	
	
	@Pending
	public WhenViewExamVivaInfo i_want_view_exam_info() {
		
		return self();
	}

	
	@Pending
	public WhenViewExamVivaInfo i_want_view_viva_info() {

		return self();
	}

}
