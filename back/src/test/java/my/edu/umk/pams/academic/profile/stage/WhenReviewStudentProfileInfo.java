package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenReviewStudentProfileInfo extends Stage<WhenReviewStudentProfileInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentProfileInfo.class);
	
    @Autowired
    private IdentityService identityService;
    

	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	List<AdAddress> address;
	
	
	
	public WhenReviewStudentProfileInfo supervisor_review_student_profile(String StudentNo) {
		
		student = identityService.findStudentByStudentNo(StudentNo);
		

		LOG.debug("Student's name : {}", student.getName());
		LOG.debug("Student's matric number : {}", student.getMatricNo());
		LOG.debug("Student's address : {}", student.getAddresses());
		LOG.debug("Student's email : {}", student.getEmail());
		LOG.debug("Student's mobile number : {}", student.getMobile());
		LOG.debug("Student's phone number : {}", student.getPhone());
		LOG.debug("Student's status	: {}", student.getStudentStatus());
		
		return self();
	}

}
