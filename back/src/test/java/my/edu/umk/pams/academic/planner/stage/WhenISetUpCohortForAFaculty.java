package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenISetUpCohortForAFaculty extends Stage<WhenISetUpCohortForAFaculty> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenISetUpCohortForAFaculty.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	public WhenISetUpCohortForAFaculty I_setup_cohort_for_a_faculty(String programCode) {
		program = plannerService.findProgramByCode(programCode);

		// find existing curriculum
		curriculum = plannerService.findCurriculumByCode(programCode + "/CRLM/0001");

		// setup cohort
		AdCohort cohort = new AdCohortImpl();
		cohort.setCode(programCode + "/CHRT/0002"); // second cohort
		cohort.setDescription("SECOND COHORT FOR PROGRAM " + programCode);
		cohort.setClassification(AdAcademicClassification.LEVEL_000);
		cohort.setCurriculum(curriculum);
		cohort.setProgram(program);
		plannerService.saveCohort(cohort);

		return self();
	}

}
