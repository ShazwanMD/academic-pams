package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenIViewStudentStatus extends Stage<WhenIViewStudentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIViewStudentStatus.class);

    @Autowired
    private IdentityService identityService;

    @ProvidedScenarioState
    private AdStudent student;
    public WhenIViewStudentStatus I_view_students_status() {
    	
		AdStudent student = identityService.findStudentByStudentNo("A17P001");
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		//try commit sekali-sekalo..var lala
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());
		
		
	     return self();
	}

}
