package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIAmUpdateGradeScale extends Stage<WhenIAmUpdateGradeScale> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmUpdateGradeScale.class);
	
	
	@Pending
	public WhenIAmUpdateGradeScale i_update_grading_scale() {
		
		
		return self();
	}

}
