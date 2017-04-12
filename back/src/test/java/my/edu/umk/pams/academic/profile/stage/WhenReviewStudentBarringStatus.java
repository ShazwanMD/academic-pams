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
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;



@JGivenStage
public class WhenReviewStudentBarringStatus extends Stage<WhenReviewStudentBarringStatus> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentBarringStatus.class);
	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private AdCohort cohort;
	
	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdCourse course;
    
	public WhenReviewStudentBarringStatus I_view_student_$_barring_status(String identityNo){
		
		//find student
				student = identityService.findStudentByMatricNo(identityNo);
				//check student status
				AdStudentStatus studentStatus = student.getStudentStatus();
				//find student's cohort
				cohort = student.getCohort();
				//find student's program
				program = cohort.getProgram();
				//find student's faculty
				faculty = program.getFaculty();
				//get student's course(S)
				List<AdCourse> courses = faculty.getCourses();	
				
				//check condition
				if (studentStatus == AdStudentStatus.BARRED){
				LOG.debug("Student's name: {}", student.getName());
				LOG.debug("Student's status: {}", studentStatus.name());
				LOG.debug("Barred From Taking Exam");
				
				LOG.debug("Program:{}", program.getCode());
				
				LOG.debug("Faculty:{}", faculty.getName());
				
				for(AdCourse course:courses){
				LOG.debug("Course(S):{}", course.getCode());
				
			    	}
				
				}	
				else{
					
					LOG.debug("NOT BARRED");
				}
				
			
		

		return self();
	}
}
