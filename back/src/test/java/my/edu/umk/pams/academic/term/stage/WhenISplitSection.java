package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@Pending
@JGivenStage
public class WhenISplitSection  extends Stage<WhenISplitSection> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenISplitSection.class);

	
	public WhenISplitSection I_split_section() {
		
		// split section from >30 to 15 if the quota exceed 30
		
		
		return self();
	}

}