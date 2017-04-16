package my.edu.umk.pams.academic.profile.stage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

@JGivenStage
public class ThenStudentRegisteredCoursesReviewed extends Stage<ThenStudentRegisteredCoursesReviewed> {

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

	public ThenStudentRegisteredCoursesReviewed student_registration_courses_reviewed() {
		faculty = plannerService.findFacultyByCode("A01");
		course = plannerService.findCourseByCode("GST5013");
		
			boolean exists = plannerService.isCourseExists("GST5013", faculty);
			Assert.isTrue(exists, "not exists");
		
 		return self();
	}

}
