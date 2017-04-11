package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIViewAppointedAdvisorInfo extends Stage<WhenIViewAppointedAdvisorInfo> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewAppointedAdvisorInfo.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private AdEnrollmentApplication application;
	
	@ProvidedScenarioState
	private AdActor advisor;

	public WhenIViewAppointedAdvisorInfo I_want_to_view_appointed_advisor_info() {

		// get advisor info from ad_enmt_apln and view decription from table ad_actr
		
		AdActor student = identityService.findStudentByMatricNo("A17P001");
		
		List<AdEnrollmentApplication> applications = termService.findEnrollmentApplications(academicSession);

		for (AdEnrollmentApplication application : applications) {
			LOG.debug("Enrollment application:" + application.getId());
			LOG.debug("Enrollment application:" + application.getAdvisor());
			
		}
		

		return self();
	}

}
