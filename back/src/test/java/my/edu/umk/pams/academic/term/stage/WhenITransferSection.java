package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import java.util.List;

@Pending
@JGivenStage
public class WhenITransferSection extends Stage<WhenIUpdateSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenITransferSection.class);

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdAcademicSession session;
	
	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	public WhenITransferSection I_transfer_section() {
		
		//transfer section into ad_enrollment table process have to confirm with en.uda first
		//find by student id and session id
		
		String referenceNo = "201720181/006";
		List <AdEnrollmentApplication> applications = termService.findEnrollmentApplications(session);
		
		for (AdEnrollmentApplication application : applications) {
			LOG.debug("Student Enrollment application: {}", applications);
		}
		
		return null;
		
	}
}
