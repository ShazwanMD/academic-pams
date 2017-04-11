package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenExamVivaUpdated extends Stage<ThenExamVivaUpdated> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmUpdateExamVivaInfo.class);
	
	

	public ThenExamVivaUpdated exam_info_updated() {
		
		return self();
		
	}

	public ThenExamVivaUpdated viva_info_updated() {
		
		
		return self();
		
	}

}
