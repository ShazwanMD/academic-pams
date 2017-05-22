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
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenReviewCourseRegistrationDetails extends Stage<WhenReviewCourseRegistrationDetails>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewCourseRegistrationDetails.class);

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	AdStudent student;
	
	@ExpectedScenarioState
	AdCourse course;
	
	@ExpectedScenarioState
	AdProgram program;
	
	@ExpectedScenarioState
	AdFaculty faculty;
	
	@ExpectedScenarioState
	AdStudentStatus studentStatus;
	
	@ExpectedScenarioState
	AdCohort cohort;
	
	@ExpectedScenarioState
	AdProgramLevel level;
	
	
	public WhenReviewCourseRegistrationDetails supervisor_review_course_registration_info_for_$(String studentNo){
		
		student = identityService.findStudentByMatricNo(studentNo);
		LOG.debug("Student_Name :{}", student.getName());
		
		studentStatus = student.getStudentStatus();
		LOG.debug("Student's Status:{}", studentStatus.name());
		
		cohort = student.getCohort();
		
		program = cohort.getProgram();
		LOG.debug("Program Code :{}", program.getCode());
		
		level = program.getLevel();
		LOG.debug("Level of Study:{}", level.getCode());
		
		faculty = program.getFaculty();
		
		List<AdCourse> courses = faculty.getCourses();
		for (AdCourse course : courses)
			LOG.debug(course.getCode());
	
		return self();
		
	}





	
	
}