package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIAmInsertGrade extends Stage<WhenIAmInsertGrade> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmInsertGrade.class);

	
	@Pending
	public WhenIAmInsertGrade i_insert_grades() {
		
		
		return self();
	
		
	}

}
