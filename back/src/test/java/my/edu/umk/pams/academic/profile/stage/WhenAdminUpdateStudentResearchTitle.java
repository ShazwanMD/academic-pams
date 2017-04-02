package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenAdminUpdateStudentResearchTitle extends Stage<WhenAdminUpdateStudentResearchTitle> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateStudentResearchTitle.class);
	
	
	
	@Pending
	public WhenAdminUpdateStudentResearchTitle Admin_update_student_research_title() {
		
		
		return self();
		
	}

}
