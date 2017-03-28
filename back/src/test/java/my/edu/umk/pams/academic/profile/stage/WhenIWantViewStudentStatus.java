package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenIWantViewStudentStatus extends Stage<WhenIWantViewStudentStatus> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantViewStudentStatus.class);

	
	@Autowired
	private IdentityService identityService;
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdActor actor;
	
	@ExpectedScenarioState
	private String identityNo;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;
	

	
	
	public WhenIWantViewStudentStatus I_view_student_current_status_for_$(String identityNo){
		
	
		AdStudent student = identityService.findStudentByStudentNo("A17P001");
		      AdStudentStatus studentStatus = student.getStudentStatus();
		        
		        LOG.debug("Student's status: {}", studentStatus.name());
		        LOG.debug("Student's status: {}", studentStatus.ordinal());
	
		
		
		return self();
	}
	
}
