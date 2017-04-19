package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenChangeAdvisor extends Stage<WhenChangeAdvisor> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIOfferCourse.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStaff advisor;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	public WhenChangeAdvisor I_want_to_change_advisor() {

		// update advisor_id in ad_enmt_apln
		application = termService.findEnrollmentApplicationByReferenceNo("201720181/001");
		Assert.notNull(application, "The application data must not be null");

		LOG.debug("Current advisor: {}", application.getAdvisor().getName());

		// update new advisor
		advisor = identityService.findStaffByStaffNo("01002A");
		Assert.notNull(advisor, "The advisor data must not be null");
		application.setAdvisor(advisor);
		termService.updateEnrollmentApplication(application);

		LOG.debug("Advisor is updated: {}", advisor.getId());
		Assert.notNull(application, "The application data should be not null");

		return self();
	}

}
