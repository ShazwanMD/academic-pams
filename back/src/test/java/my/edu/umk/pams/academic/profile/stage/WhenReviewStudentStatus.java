package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

public class WhenReviewStudentStatus extends Stage<WhenReviewStudentStatus> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentStatus.class);
	
	@Autowired
	private IdentityService identityService;

	  @ExpectedScenarioState
		private AdStudent student;

	    @ExpectedScenarioState
		private AdStudentStatus studentStatus;
	
	public WhenReviewStudentStatus I_view_student_current_status_for_$(String identityNo) {
		
		student = identityService.findStudentByStudentNo(identityNo);
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());

		
		return self();

		
	}

}
