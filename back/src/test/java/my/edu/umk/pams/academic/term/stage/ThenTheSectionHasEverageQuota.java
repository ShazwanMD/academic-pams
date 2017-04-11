package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@Pending
@JGivenStage
public class ThenTheSectionHasEverageQuota extends Stage<ThenTheSectionHasEverageQuota> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheSectionHasEverageQuota.class);

	public ThenTheSectionHasEverageQuota the_section_has_average_quota() {
		
		//check the new quota from the table
		
		return self();

	}

}
