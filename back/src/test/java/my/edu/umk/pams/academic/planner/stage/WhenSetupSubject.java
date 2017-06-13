package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenSetupSubject extends Stage<WhenSetupSubject> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenSetupSubject.class);

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
	AdCohort cohort;

	@ExpectedScenarioState
	private AdCurriculum curriculum;

	@ProvidedScenarioState
	private AdSingleSubject subject;

	public WhenSetupSubject I_setup_subject_$(String coursecode, String facultycode) {

		faculty = plannerService.findFacultyByCode(facultycode);
		course = plannerService.findCourseByCode(coursecode);

		LOG.debug("faculty : {}", faculty.getCode());
		LOG.debug("course : {}", course.getCode());

		subject = new AdSingleSubjectImpl();
		subject.setOrdinal(1);
		subject.setSubjectType(AdSubjectType.CORE);
		subject.setCourse(course);
		subject.setCurriculum(curriculum);
		plannerService.addSubject(curriculum, subject);

		LOG.debug("subject type : {}", subject.getSubjectType());
		LOG.debug("subject period : {}", subject.getOrdinal());
		LOG.debug("course : {}", subject.getCourse().getCode());
		LOG.debug("curriculum : {}", subject.getCurriculum().getCode());
		
		
		return self();
	}
}