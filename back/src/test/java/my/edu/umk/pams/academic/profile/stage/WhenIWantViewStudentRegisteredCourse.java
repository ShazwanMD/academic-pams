package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
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
public class WhenIWantViewStudentRegisteredCourse extends Stage<WhenIWantViewStudentRegisteredCourse> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantViewStudentRegisteredCourse.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdStudentStatus studentStatus;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdCohort cohort;


	public WhenIWantViewStudentRegisteredCourse I_want_view_student_registered_course_$(String identityNo) {

		//student
		student = identityService.findStudentByMatricNo(identityNo);
		LOG.debug("Student's name : {}", student.getName());
		//student status
	    studentStatus = student.getStudentStatus();
		LOG.debug("Student's status: {}", studentStatus.name());
		
		if(studentStatus == AdStudentStatus.ACTIVE){
		//cohort
		cohort = student.getCohort();
		LOG.debug("Cohort:{}", cohort.getCode());
		//program
		program = cohort.getProgram();
		LOG.debug("Program Registered:{}", program.getCode());
		//faculty
		faculty = program.getFaculty();
		LOG.debug("Faculty:{}", faculty.getName());
		//level
		level = program.getProgramLevel();
		LOG.debug("Level of Study:{}", level.getCode());
		//course
		List<AdCourse> courses = faculty.getCourses();
		for(AdCourse course : courses){
			
			LOG.debug("Course Taken : {}", course.getCode());
		}

		}else if(studentStatus == AdStudentStatus.INACTIVE){
			//cohort
			cohort = student.getCohort();
			LOG.debug("Cohort:{}", cohort.getCode());
			//program
			program = cohort.getProgram();
			LOG.debug("Program Registered:{}", program.getCode());
			//faculty
			faculty = program.getFaculty();
			LOG.debug("Faculty:{}", faculty.getName());
		
		}else if(studentStatus == AdStudentStatus.BARRED){
			//cohort
			cohort = student.getCohort();
			LOG.debug("Cohort:{}", cohort.getCode());
			//program
			program = cohort.getProgram();
			LOG.debug("Program Registered:{}", program.getCode());
			//faculty
			faculty = program.getFaculty();
			LOG.debug("Faculty:{}", faculty.getName());
			//level
			level = program.getProgramLevel();
			LOG.debug("Level of Study:{}", level.getCode());
			//course
			List<AdCourse> courses = faculty.getCourses();
			for(AdCourse course : courses){
				
				LOG.debug("Course Taken : {}", course.getCode());
			
		}
			
		}else if (studentStatus == AdStudentStatus.GRADUATED){
			
			//cohort
			cohort = student.getCohort();
			LOG.debug("Cohort:{}", cohort.getCode());
			//program
			program = cohort.getProgram();
			LOG.debug("Program Registered:{}", program.getCode());
			//faculty
			faculty = program.getFaculty();
			LOG.debug("Faculty:{}", faculty.getName());
			//level
			level = program.getProgramLevel();
			LOG.debug("Level of Study:{}", level.getCode());
			//course
			List<AdCourse> courses = faculty.getCourses();
			for(AdCourse course : courses){
				
				LOG.debug("Course Taken : {}", course.getCode());
			
		}
		
		
		}
		
	

		return self();
		
}
}
