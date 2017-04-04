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
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCreditType;
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
	
	private String identityNo;

	public WhenIWantViewStudentRegisteredCourse I_want_view_student_registered_course_$(String identityNo) {

		AdActor actor = identityService.findActorByIdentityNo(identityNo);
		AdStudent student = identityService.findStudentByStudentNo(identityNo);
		AdStudentStatus studentStatus = student.getStudentStatus();

		LOG.debug("Student's name : {}", actor.getName());
		LOG.debug("Student's email : {}", actor.getEmail());
		LOG.debug("Student's status: {}", studentStatus.name());

		AdProgram program = plannerService.findProgramByCode("FKP/MASTER/0008");
		AdFaculty faculty = plannerService.findFacultyByCode("FKP");
		AdProgramLevel level = plannerService.findProgramLevelByCode("PHD");
		LOG.debug("Faculty : {}", faculty.getName());
		LOG.debug("Program Level : {}",level.getCode());
		LOG.debug("Program Level : {}",level.getDescription());
		LOG.debug("Program : {}", program.getTitle());
		LOG.debug("Program : {}", program.getTitleEn());
		LOG.debug("Program : {}", program.getTitleMs());
		
		faculty = plannerService.findFacultyByCode("FKP");
		List<AdCourse> courses = plannerService.findCourses(faculty);
		
		for(AdCourse course : courses){
			
			LOG.debug("Course Taken : {}", course.getTitle());

			LOG.debug("Course Taken : {}", course.getTitleEn());

			LOG.debug("Course Taken : {}", course.getTitleMs());
			
		}

		
		
		return self();

	}

}
