package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
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

	@ExpectedScenarioState
	private String code;
	
	public ThenCurriculumHasAdded Curriculum_has_added() {
		//
		// LOG.debug("New curriculum has been added: {} ",
		// curriculum.getCode());
		// Assert.notNull(curriculum, "curriculum data has been added");

//		boolean exists = plannerService.isProgramExists(code, faculty);
//		Assert.isTrue(exists, "program does not have curriculum");

//		 AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
//		
//		 Assert.isTrue(curriculum.equals(curriculum), "true");

		return self();
		
	}

}
