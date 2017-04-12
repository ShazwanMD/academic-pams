package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class thenExamVivaInfoCurrent extends Stage<thenExamVivaInfoCurrent> {

	@Pending
	public thenExamVivaInfoCurrent exam_info_current() {


		return self();
		
	}

	@Pending
	public thenExamVivaInfoCurrent viva_info_current() {
		
		return self();
		
	}

}
