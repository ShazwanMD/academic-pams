package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIViewMyStudentStatus extends Stage<WhenIViewMyStudentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIViewMyStudentStatus.class);

    @Autowired
    private IdentityService identityService;

    @ProvidedScenarioState
    private AdStudent student;
    
    @ProvidedScenarioState
    private AdStudentStatus studentStatus;

    @ProvidedScenarioState
    private AdActor actor;
    
	public WhenIViewMyStudentStatus I_view_student_status() {
	
		AdStudent student = identityService.findStudentByStudentNo("A17P001");
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());
		
		
	     return self();
	}

}


