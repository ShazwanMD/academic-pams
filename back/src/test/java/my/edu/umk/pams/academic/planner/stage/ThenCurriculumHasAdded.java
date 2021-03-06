package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

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

	public ThenCurriculumHasAdded Curriculum_has_added() {

//		LOG.debug("New curriculum has been added: {} ", curriculum.getCode());
		Assert.notNull(curriculum, "curriculum data has been added");
		return self();

	}

	public ThenCurriculumHasAdded Curriculum_has_reviewed() {

		LOG.debug("Curriculum has been reviewed: {} ", curriculum.getCode());
		Assert.notNull(curriculum, "curriculum data has been reviewed");

		return self();
	}

}
