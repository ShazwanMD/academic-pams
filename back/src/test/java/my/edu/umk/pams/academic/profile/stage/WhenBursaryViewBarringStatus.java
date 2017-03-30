package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenBursaryViewBarringStatus extends Stage<WhenBursaryViewBarringStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBursaryViewBarringStatus.class);

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdStudent student;




	public WhenBursaryViewBarringStatus I_view_barring_status_$(String identityNo) {
		
		student = identityService.findStudentByStudentNo("A17P002");
		AdStudentStatus studentStatus = student.getStudentStatus();

		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());

		return self();
	}

}