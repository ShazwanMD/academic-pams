package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIAmUpdateExamVivaInfo extends Stage<WhenIAmUpdateExamVivaInfo> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmUpdateExamVivaInfo.class);
	
	
	
	
	
	

	public WhenIAmUpdateExamVivaInfo i_update_examination_info() {


		return self();
		
	}

	public WhenIAmUpdateExamVivaInfo i_update_viva_info() {
		
		return self();
		
	}

}
