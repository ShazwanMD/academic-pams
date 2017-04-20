package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;

import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.identity.service.IdentityService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIReviewActivationStatus extends Stage<WhenIReviewActivationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewActivationStatus.class);

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private ProfileService profileService;
	
    @ExpectedScenarioState
	private AdStudent student;
    
    @ExpectedScenarioState
   	private AdProgram program;
    
    @ExpectedScenarioState
   	private AdProgramLevel level;
    
    @ExpectedScenarioState
   	private List<AdCourse> courses;
    
    @ExpectedScenarioState
   	private AdFaculty faculty;
    
    @ExpectedScenarioState
   	private AdCohort cohort;

    @ExpectedScenarioState
	private AdStudentStatus studentStatus;
    
	public WhenIReviewActivationStatus I_review_activation_status_$(String identityNo) {
		
	student = identityService.findStudentByMatricNo(identityNo);
    studentStatus = student.getStudentStatus();
    cohort = student.getCohort();
    program = cohort.getProgram();
    faculty = program.getFaculty();
    level = program.getProgramLevel();
    courses = faculty.getCourses();
		
		if(studentStatus == AdStudentStatus.ACTIVE){
			//student details		
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			//student status
			LOG.debug("Student's status: {}", studentStatus.name());
			
			//student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			
			//program
			LOG.debug("Program : {}", program.getCode());
			
			//program level
			LOG.debug("Program Level :{}", level.getCode());
			
			//faculty
			LOG.debug("Faculty:{}", faculty.getName());
			
			//courses
				for(AdCourse course:courses)
					LOG.debug("Courses Registered:{}", course.getCode());
		
			//Deactivate student status from old status
		    student.setStudentStatus(AdStudentStatus.INACTIVE);
		    profileService.deactivateStudent(student);
		    LOG.debug("Student New Status:{}",student.getStudentStatus());
				
		}
		
		else if(studentStatus == AdStudentStatus.MATRICULATED){
			
			//student details		
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			//student status
			LOG.debug("Student's status: {}", studentStatus.name());
			
			//student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			
			//program
			LOG.debug("{Program :{}", program.getCode());
			
			//program level
			LOG.debug("Program Level :{}", level.getCode());
			
			//faculty
			LOG.debug("Faculty:{}", faculty.getName());
			
			//courses
			for(AdCourse course:courses)
				LOG.debug("Courses Registered:{}", course.getCode());
		
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	    	
	    }
		
		else if(studentStatus == AdStudentStatus.INACTIVE){
	    	
			//student details		
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			//student status
			LOG.debug("Student's status: {}", studentStatus.name());
			
			//student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			
			//program
			LOG.debug("{Program :{}", program.getCode());
			
			//program level
			LOG.debug("Program Level :{}", level.getCode());
			
			//faculty
			LOG.debug("Faculty:{}", faculty.getName());
			
			//courses
			for(AdCourse course:courses)
				LOG.debug("Courses Registered:{}", course.getCode());
			
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
			
		}
		
		else if(studentStatus == AdStudentStatus.BARRED){
			
			//student details		
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			//student status
			LOG.debug("Student's status: {}", studentStatus.name());
			
			//student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			
			//program
			LOG.debug("{Program :{}", program.getCode());
			
			//program level
			LOG.debug("Program Level :{}", level.getCode());
			
			//faculty
			LOG.debug("Faculty:{}", faculty.getName());
			
			//courses
			for(AdCourse course:courses)
				LOG.debug("Courses Registered:{}", course.getCode());
		
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	    	
		}
		
		else if(studentStatus == AdStudentStatus.GRADUATED){
			
			//student details		
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			
			//student status
			LOG.debug("Student's status: {}", studentStatus.name());
			
			//student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			
			//program
			LOG.debug("{Program :{}", program.getCode());
			
			//program level
			LOG.debug("Program Level :{}", level.getCode());
			
			//faculty
			LOG.debug("Faculty:{}", faculty.getName());
			
			//courses
			for(AdCourse course:courses)
				LOG.debug("Courses Registered:{}", course.getCode());
		
			//Activate student status from old status
	        student.setStudentStatus(AdStudentStatus.ACTIVE);
	        profileService.activateStudent(student);
	        LOG.debug("Student New Status:{}",student.getStudentStatus());
	    	
		}
		
		else{
			
			LOG.debug("You Are Not Registered Student");
		};
		
		return self();
	}


}
