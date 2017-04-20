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
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class WhenBursaryViewBarringStatus extends Stage<WhenBursaryViewBarringStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBursaryViewBarringStatus.class);

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private ProfileService profileService;
	
	@ExpectedScenarioState
	private AdStudent student;


	public WhenBursaryViewBarringStatus I_view_barring_status_$(String identityNo) {
		
		student = identityService.findStudentByMatricNo("A17P002");
		AdStudentStatus studentStatus = student.getStudentStatus();
		LOG.debug("Student's Name:{}", student.getName());
	    LOG.debug("Student's Matric No :{}", student.getMatricNo());
		LOG.debug("Student's Status: {}", studentStatus.name());
		
		//Activate student status from old status
        student.setStudentStatus(AdStudentStatus.ACTIVE);
        profileService.activateStudent(student);
        LOG.debug("Student New Status:{}",student.getStudentStatus());
    	
		return self();
	}

}
