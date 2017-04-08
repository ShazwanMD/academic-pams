package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIReviewActivationStatus extends Stage<WhenIReviewActivationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewActivationStatus.class);

	@Autowired
	private IdentityService identityService;

    @ExpectedScenarioState
	private AdStudent student;

    @ExpectedScenarioState
	private AdStudentStatus studentStatus;


	public WhenIReviewActivationStatus I_review_activation_status_$(String identityNo) {

		student = identityService.findStudentByMatricNo(identityNo);
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());

		return self();
	}

}
