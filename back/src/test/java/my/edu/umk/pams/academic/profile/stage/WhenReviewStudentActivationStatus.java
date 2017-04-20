package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class WhenReviewStudentActivationStatus extends Stage <WhenReviewStudentActivationStatus>{

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentActivationStatus.class);

	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private ProfileService profileService;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;
	
    @ExpectedScenarioState
   	private AdProgram program;
    
    @ExpectedScenarioState
   	private AdProgramLevel level;
    
    @ExpectedScenarioState
   	private List<AdCourse> courses;
    
    @ExpectedScenarioState
   	private AdFaculty faculty;
	
	public WhenReviewStudentActivationStatus supervisor_review_student_activation_status(String identityNo) {
		student = identityService.findStudentByMatricNo(identityNo);
	    studentStatus = student.getStudentStatus();
		faculty = plannerService.findFacultyByCode("A01");
		program = plannerService.findProgramByCodeAndFaculty("FKP/PHD/PAM", faculty);
		courses = plannerService.findCourses(faculty);
		
		if(studentStatus == AdStudentStatus.ACTIVE){
				
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());
			
			LOG.debug("Faculty Name :{}", faculty.getName());
	
			LOG.debug("Program CODE:{}", program.getCode());
			LOG.debug("Program Details:{}", program.getTitle());
			LOG.debug("Program Details:{}", program.getTitleEn());
			LOG.debug("Program Details:{}", program.getTitleMs());
	
			for(AdCourse course:courses)
				LOG.debug("Courses Registered:{}", course.getCode());
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.INACTIVE);
	        profileService.deactivateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
		
		}else if(studentStatus == AdStudentStatus.MATRICULATED){
			
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
		
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
		
	    }else if(studentStatus == AdStudentStatus.INACTIVE){
	
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
		
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	        
		}else if(studentStatus == AdStudentStatus.BARRED){
			
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			LOG.debug("Student's status: {}", studentStatus.name());
		    LOG.debug("Student's status: {}", studentStatus.ordinal());

		    //Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	        
		}else if(studentStatus == AdStudentStatus.GRADUATED){
			
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
	
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());
			
			LOG.debug("Faculty Name :{}", faculty.getName());

			LOG.debug("Program CODE:{}", program.getCode());
			LOG.debug("Program Taken:{}", program.getTitle());
			LOG.debug("Program Taken:{}", program.getTitleEn());
			LOG.debug("Program Taken:{}", program.getTitleMs());
			
			for(AdCourse course:courses)
				LOG.debug("Courses  Taken:{}", course.getCode());
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
		
		}else{
			
			LOG.debug("You Are Not Registered Student");
		};

		
		return self();		
	}

}
