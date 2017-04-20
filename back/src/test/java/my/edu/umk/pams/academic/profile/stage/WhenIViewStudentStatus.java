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
public class WhenIViewStudentStatus extends Stage<WhenIViewStudentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIViewStudentStatus.class);

    @Autowired
    private IdentityService identityService;
    
    @Autowired
    private ProfileService profileService;

    @ExpectedScenarioState
    private AdStudent student;

    public WhenIViewStudentStatus I_view_student_$_status(String identityNo) {
    	
	 student = identityService.findStudentByMatricNo(identityNo);
		
	 AdStudentStatus studentStatus = student.getStudentStatus();
	 if (studentStatus == AdStudentStatus.ACTIVE) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());
			
			 //Deactivate student status from old status
	        student.setStudentStatus(AdStudentStatus.INACTIVE);
	        profileService.deactivateStudent(student);
	        LOG.debug("StudentNewStatus:{}",student.getStudentStatus());

	        
		} else if (studentStatus == AdStudentStatus.MATRICULATED) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	    	
			
		} else if (studentStatus == AdStudentStatus.INACTIVE) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	    	
			
		} else if (studentStatus == AdStudentStatus.BARRED) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());

	        
		} else if (studentStatus == AdStudentStatus.GRADUATED) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	    	
	        
		} else {

			LOG.debug("You Are Not Registered Student");
		}
		;
		
	     return self();
	}

}
