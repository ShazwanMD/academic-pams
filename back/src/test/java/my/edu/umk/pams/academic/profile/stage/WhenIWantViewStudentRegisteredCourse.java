package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class WhenIWantViewStudentRegisteredCourse extends Stage<WhenIWantViewStudentRegisteredCourse> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantViewStudentRegisteredCourse.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdProgramLevel level;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdStudentStatus studentStatus;
	
	@ProvidedScenarioState
	private AdFaculty faculty;
	
	@ProvidedScenarioState
	private AdCohort cohort;
	
	public WhenIWantViewStudentRegisteredCourse I_want_view_student_registered_course_$(String identityNo) {

		
		student = identityService.findStudentByMatricNo(identityNo);
		Assert.notNull(student, "Student Must Not NULL");
		studentStatus = student.getStudentStatus();
		LOG.debug("Student's name : {}", student.getName());
		LOG.debug("Student's email : {}", student.getEmail());
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("");

		cohort = student.getCohort();
		Assert.notNull(cohort, "Cohort Must Not Null");
		
		program  = cohort.getProgram();
		Assert.notNull(program, "Program Must Not Null");
		faculty = program.getFaculty();
		Assert.notNull(faculty, "Faculty Must Not Null");
		List<AdCourse> courses = faculty.getCourses();
		Assert.notNull(courses, "Course(s) Must Not Null");
		level = program.getLevel();
		Assert.notNull(level, "Level of Study Must Not Null");
		
		LOG.debug("Faculty : {}", faculty.getDescription());
		LOG.debug("Program Level : {}",level.getCode());
		LOG.debug("Program Level : {}",level.getDescription());
		LOG.debug("Program : {}", program.getTitleEn());
		LOG.debug("Program : {}", program.getTitleMs());
		
		for(AdCourse course : courses){
			
			LOG.debug("Course Taken : {}", course.getTitleMs());

			LOG.debug("Course Taken : {}", course.getTitleEn());

			LOG.debug("Course Taken : {}", course.getTitleMs());
			
		}

		
		
		return self();

	}

}
