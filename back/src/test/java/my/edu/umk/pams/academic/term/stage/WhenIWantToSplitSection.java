package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIWantToSplitSection extends Stage<WhenIWantToSplitSection> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSplitSection.class);
	
	public WhenIWantToSplitSection I_want_to_split_section() {
		
		return self();
	}

}
