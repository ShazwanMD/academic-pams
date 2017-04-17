package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * As an admin academic, 
 * i want to set up curriculum for a faculty, 
 * so that i can manage schedule by program.
 * @author zaida_ain
 */

@JGivenStage
public class WhenAdminAddCurriculum extends Stage<WhenAdminAddCurriculum> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddCurriculum.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	public WhenAdminAddCurriculum Admin_add_curriculum(){

		// setting up curriculum
		AdProgram program = plannerService.findProgramByCode("");
		curriculum = new AdCurriculumImpl();
		curriculum.setCode(program.getCode() + "/" + "CRLM/0005"); // FKP/MASTER/0008/CRLM/0001
		curriculum.setOrdinal(1);
		curriculum.setCoreCredit(3);
		curriculum.setElectiveCredit(3);
		curriculum.setGeneralCredit(3);
		curriculum.setRequiredCredit(3);
		curriculum.setLanguageCredit(3);
		curriculum.setCurriculumCredit(1);
		curriculum.setOthersCredit(1);
		curriculum.setTotalCredit(3);
		curriculum.setMaxPeriod(5);
		curriculum.setPeriod(4);
		curriculum.setProgram(program);
		
		plannerService.saveCurriculum(curriculum);

		LOG.debug("curriculum : {}", curriculum.getCode());
		LOG.debug("curriculum has added: {}", curriculum.getCode());
		
		
		  return self();
    }
	
	
	public WhenAdminAddCurriculum I_review_set_curriculum(){

		// review set curriculum
		AdFaculty faculty = plannerService.findFacultyByCode("A10");
		AdAcademicSession academicSession= plannerService.findAcademicSessionByCode("201720181");
		AdProgramLevel level = plannerService.findProgramLevelByCode("PHD");
		//AdProgram program = plannerService.findProgramByCode();
	
		LOG.debug("AcademicSession :{}", academicSession.getSemester());
		LOG.debug("Faculty : {}", faculty.getDescription());
		LOG.debug("Program Level : {}", level.getCode());
		LOG.debug("Program Level : {}", level.getDescription());
		LOG.debug("Program : {}", program.getTitle());
		LOG.debug("Program : {}", program.getTitleEn());
		LOG.debug("Program : {}", program.getTitleMs());

	
		faculty = plannerService.findFacultyByCode("A10");
	

		List<AdCourse> courses = plannerService.findCourses(faculty);

		for (AdCourse course : courses) {

			LOG.debug("Course Taken : {}", course.getTitle());

			LOG.debug("Course Taken : {}", course.getTitleEn());

			LOG.debug("Course Taken : {}", course.getTitleMs());

		}

		return self();
	}

}