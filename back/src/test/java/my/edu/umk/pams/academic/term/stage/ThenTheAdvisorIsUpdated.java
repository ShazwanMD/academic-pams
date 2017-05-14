package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenTheAdvisorIsUpdated extends Stage<ThenTheAdvisorIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdvisorIsUpdated.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdEnrollmentApplication application;

	@ExpectedScenarioState
	private AdStaff advisor;

	public ThenTheAdvisorIsUpdated The_advisor_is_updated() {

		LOG.debug("Advisor is updated: {}", advisor.getId());

		// assert notNull ad_enmt_apln and view new data
		Assert.notNull(application, "The data must not be null");
		LOG.debug("Advisor is updated: {}", advisor.getName());
		LOG.debug("Advisor for student: {}", application.getAdmission().getStudent().getName());
		LOG.debug("Advisor for session: {}", application.getSession().getDescription());

		return self();
	}
}
