package my.edu.umk.pams.academic.profile.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;


@JGivenStage
public class WhenReviewCourseRegistration extends Stage<WhenReviewCourseRegistration> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewCourseRegistration.class);
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ProvidedScenarioState
	private	AdStudent student;
	
	@ProvidedScenarioState
	private	AdStudentStatus studentStatus;
	
	@ProvidedScenarioState
	private List<AdCourse> courses;
	
	@ProvidedScenarioState
	private	AdCohort cohort;
	
	@ProvidedScenarioState
	private AdFaculty faculty;
	
	@ProvidedScenarioState
	private AdProgram program;
	
	public WhenReviewCourseRegistration I_view_student_$_course_registration(String identityNo) {
	
		//find student by matric no and get get information using matric no
		student = identityService.findStudentByMatricNo(identityNo);
		studentStatus = student.getStudentStatus();
		cohort = student.getCohort();
		program = cohort.getProgram();
		faculty = program.getFaculty();
		courses = faculty.getCourses();

		LOG.debug("Student's Name:{}", student.getName());
		
		LOG.debug("Student's Status:{}", studentStatus.name());
		
		LOG.debug("Cohort:{}", cohort.getCode());
				
		LOG.debug("Program:{}", program.getCode());
		
		LOG.debug("Faculty:{}", faculty.getName());
		
		for (AdCourse course : courses) {
			LOG.debug(course.getTitle());
		}
		
		return self();
	}

	@Pending
	public WhenReviewCourseRegistration I_view_student_payment_status() {

		return self();
	}

}
