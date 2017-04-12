package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenGradeScaleUpdated extends Stage<ThenGradeScaleUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenGradeScaleUpdated.class);
	
	@Pending
	public ThenGradeScaleUpdated grading_scale_updated() {
		
		return self();
		
	}

}
