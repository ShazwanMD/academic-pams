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
public class WhenLecturerReviewStudentGraduationStatus extends Stage<WhenLecturerReviewStudentGraduationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenLecturerReviewStudentGraduationStatus.class);
	
	@Autowired
	private IdentityService identityService;
   
	@Autowired
    private ProfileService profileService;
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	public WhenLecturerReviewStudentGraduationStatus lecturer_review_student_graduation_status (String identityNo) {
	
		student = identityService.findStudentByMatricNo(identityNo);
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		if(studentStatus == AdStudentStatus.GRADUATED){
		LOG.debug("Student's name: {}", student.getName());
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Congratulations");
		
		}else {
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
		        LOG.debug("Student New Status:{}",student.getStudentStatus());
				LOG.debug("NOT GRADUATED YET");
		}
		
		return self();
		
	}

}
