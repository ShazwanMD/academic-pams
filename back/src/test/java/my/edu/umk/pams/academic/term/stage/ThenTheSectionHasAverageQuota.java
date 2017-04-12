package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheSectionHasAverageQuota extends Stage<ThenTheSectionHasAverageQuota> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheSectionHasAverageQuota.class);
	
	public ThenTheSectionHasAverageQuota the_section_has_average_quota() {
		
		return self();
	}
}
