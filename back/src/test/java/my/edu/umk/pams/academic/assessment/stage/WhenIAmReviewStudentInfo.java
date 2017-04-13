package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIAmReviewStudentInfo extends Stage<WhenIAmReviewStudentInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmReviewStudentInfo.class);
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private TermService termService;
	
	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdProgramLevel level;

	@ProvidedScenarioState
	private AdFaculty faculty;
	
	@ProvidedScenarioState
	private AdAcademicSession session;
	
	@ExpectedScenarioState
	public String matricNo;
	
	public WhenIAmReviewStudentInfo i_review_student_info() {
		
		student = identityService.findStudentByMatricNo(matricNo);
		LOG.debug("Student Name :{}", student.getName());
		LOG.debug("Student Matric No :{}", student.getMatricNo());
		
		studentStatus = student.getStudentStatus();
		LOG.debug("Student Status :{}", studentStatus.name());
			
		//find by cohort
		cohort = student.getCohort();
		LOG.debug("Cohort :{}", cohort.getCode());
		
		//get student program
		program = cohort.getProgram();
		LOG.debug("Program :{}", program.getTitle());
		
		//get student level of study
		level = program.getProgramLevel();
		LOG.debug("Level of Study :{}", level.getCode());
		
		//get faculty
		faculty = program.getFaculty();
		LOG.debug("Faculty :{}", faculty.getName());
		
		if(studentStatus == AdStudentStatus.ACTIVE){
		//list course taken
		List<AdCourse> courses = faculty.getCourses();
		for(AdCourse course:courses){
			LOG.debug("Course(s) :{}", course.getCode());
		}
	}
		if(studentStatus == AdStudentStatus.GRADUATED){
			//list course taken
			List<AdCourse> courses = faculty.getCourses();
			for(AdCourse course:courses){
				LOG.debug("Course(s) :{}", course.getCode());
			}
		}
		
		
		return self();
		
	}

}
