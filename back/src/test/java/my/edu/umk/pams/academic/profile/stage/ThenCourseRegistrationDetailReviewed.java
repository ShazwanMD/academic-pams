package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.planner.stage.ThenFacultyHasCourse;

@JGivenStage
public class ThenCourseRegistrationDetailReviewed extends Stage<ThenCourseRegistrationDetailReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenCourseRegistrationDetailReviewed.class);
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private IdentityService identityService;
	
	@ExpectedScenarioState
	AdStudent student;
	
	@ExpectedScenarioState
	AdCourse course;
	
	@ExpectedScenarioState
	AdProgram program;
	
	@ProvidedScenarioState
	AdFaculty faculty;
	
	public ThenCourseRegistrationDetailReviewed  course_registration_details_reviewed_for_$(String studentNo) {
		
		student = identityService.findStudentByMatricNo(studentNo);
		faculty = program.getFaculty();

		List<AdCourse> courses = plannerService.findCourses(faculty);
		Assert.notEmpty(courses, "Course Must Register First");
		
		return self();
	}

}
