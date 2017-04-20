package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.profile.service.ProfileService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenAccessStudentStatus extends Stage<WhenAccessStudentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAccessStudentStatus.class);

    @Autowired
    private IdentityService identityService;
    
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
    
    @ExpectedScenarioState
   	private AdCohort cohort;
    
    public WhenAccessStudentStatus i_access_student_status(String identityNo) {
        
    	student = identityService.findStudentByMatricNo(identityNo);
        studentStatus = student.getStudentStatus();
        cohort = student.getCohort();
        program = cohort.getProgram();
        faculty = program.getFaculty();
        level = program.getProgramLevel();
        courses = faculty.getCourses();
    	
    	if(studentStatus == AdStudentStatus.ACTIVE) {
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			LOG.debug("{Program :{}", program.getCode());
			LOG.debug("Program Level :{}", level.getCode());
			LOG.debug("Faculty:{}", faculty.getName());
				for(AdCourse course:courses)
					LOG.debug("Course's Registered:{}", course.getCode());
		}
    	
		else if(studentStatus == AdStudentStatus.MATRICULATED){
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			LOG.debug("{Program :{}", program.getCode());
			LOG.debug("Program Level :{}", level.getCode());
			LOG.debug("Faculty:{}", faculty.getName());
			for(AdCourse course:courses)
				LOG.debug("Course's Registered:{}", course.getCode());
	    }

		else if(studentStatus == AdStudentStatus.INACTIVE){
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			LOG.debug("{Program :{}", program.getCode());
			LOG.debug("Program Level :{}", level.getCode());
			LOG.debug("Faculty:{}", faculty.getName());
			for(AdCourse course:courses)
				LOG.debug("Course's Registered:{}", course.getCode());
		}

		else if(studentStatus == AdStudentStatus.BARRED){
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			LOG.debug("{Program :{}", program.getCode());
			LOG.debug("Program Level :{}", level.getCode());
			LOG.debug("Faculty:{}", faculty.getName());
			for(AdCourse course:courses)
				LOG.debug("Course's Registered:{}", course.getCode());
		}

		else if(studentStatus == AdStudentStatus.GRADUATED){
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			LOG.debug("{Program :{}", program.getCode());
			LOG.debug("Program Level :{}", level.getCode());
			LOG.debug("Faculty:{}", faculty.getName());
			for(AdCourse course:courses)
				LOG.debug("Course's Registered:{}", course.getCode());
		}

		else{
			LOG.debug("You Are Not Registered Student");
		};
		
		//Activate Student Status from old status
        student.setStudentStatus(AdStudentStatus.ACTIVE);
        profileService.activateStudent(student);
        LOG.debug("StudentNewStatus:{}",student.getStudentStatus());
		
		return self();
	}
}