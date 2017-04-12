package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

@JGivenStage
public class WhenIViewStudentInfo extends Stage<WhenIViewStudentInfo>  {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewStudentInfo.class);
	
	@Autowired
	private IdentityService identityService;

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

	public WhenIViewStudentInfo i_view_student_info(String identityNo) {

		//find student
		student = identityService.findStudentByMatricNo(identityNo);
		LOG.debug("Student's Name :{}", student.getName());
		LOG.debug("Student's MatricNo :{}", student.getMatricNo());
		
		//get student status
		studentStatus = student.getStudentStatus();
		LOG.debug("Student's Status :{}", studentStatus.name());
		
		//find by cohort
		cohort = student.getCohort();
		
		//get student program
		program = cohort.getProgram();
		LOG.debug("Program :{}", program.getTitle());
		
		//get student level of study
		level = program.getProgramLevel();
		LOG.debug("Level of Study :{}", level.getCode());
		
		//get faculty
		faculty = program.getFaculty();
		LOG.debug("Faculty :{}", faculty.getName());
		
		//list course taken
		List<AdCourse> courses = faculty.getCourses();
		for(AdCourse course:courses){
			LOG.debug("Course(s) :{}", course.getCode());
		}
		return self();
	}


}
