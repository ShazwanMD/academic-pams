package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;



@JGivenStage
public class ThenStudentResearchTitleUpdatedByAdmin extends Stage<ThenStudentResearchTitleUpdatedByAdmin> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentResearchTitleUpdatedByAdmin.class);
	
	
	@Pending
	public ThenStudentResearchTitleUpdatedByAdmin Student_research_title_updated_by_admin() {
		
		return self();
		
	}

}
