package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class ThenCurriculumHasAdded extends Stage<ThenCurriculumHasAdded> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenCurriculumHasAdded.class);

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

	@ExpectedScenarioState
	private AdCurriculum curriculum;

	public ThenCurriculumHasAdded curriculum_is_added() {
//		LOG.debug("New curriculum has been added: {} ", curriculum.getCode());
		Assert.notNull(curriculum, "curriculum cannnot be null");
		return self();
	}

	public ThenCurriculumHasAdded print_to_console() {
			// review set curriculum
//		AdFaculty faculty = plannerService.findFacultyByCode("A10");
			AdAcademicSession academicSession= plannerService.findAcademicSessionByCode("201720181");
			AdProgramLevel level = plannerService.findProgramLevelByCode("PHD");
			AdProgram program = plannerService.findProgramByCode("A10");
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
