package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenReviewStudentActivationStatus extends Stage <WhenReviewStudentActivationStatus>{

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentActivationStatus.class);

	
	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;
	
	public WhenReviewStudentActivationStatus supervisor_review_student_activation_status(String identityNo) {
		
		student = identityService.findStudentByStudentNo(identityNo);
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's name: {}", student.getName());
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());

		
		return self();		
	}

}
