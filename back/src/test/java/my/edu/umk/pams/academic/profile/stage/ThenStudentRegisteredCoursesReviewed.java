package my.edu.umk.pams.academic.profile.stage;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

@JGivenStage
public class ThenStudentRegisteredCoursesReviewed extends Stage<ThenStudentRegisteredCoursesReviewed> {

	@Autowired
	private IdentityService identityService;
	
    @Autowired
    private PlannerService plannerService;
    
    @ExpectedScenarioState
    private AdSection section;
	
    @ExpectedScenarioState
    private AdStudent student;
    
    @ExpectedScenarioState
    private AdCourse course;
    
    @ExpectedScenarioState
    private AdOffering offering;
    
    @ProvidedScenarioState
    private AdFaculty faculty;
    
    @ExpectedScenarioState
	private String identityNo;
    
    @ExpectedScenarioState
  	private AdCohort cohort;
    
    @ExpectedScenarioState
  	private AdProgram program;

	public ThenStudentRegisteredCoursesReviewed student_registration_courses_reviewed(String identityNo) {
		
		student = identityService.findStudentByMatricNo(identityNo);
		Assert.notNull(student, "Student Must Not NULL");
		cohort = student.getCohort();

		program = cohort.getProgram();
		Assert.notNull(program, "Program Must Not NULL");
		faculty = program.getFaculty();
		boolean exists = plannerService.isFacultyExists("A07");
		Assert.isTrue(exists, "Faculty Must Exists");
		List<AdCourse> courses = faculty.getCourses();
		Assert.notEmpty(courses, "Course Must Register First");
		

 		return self();
	}

}
