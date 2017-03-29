package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * As an admin academic, 
 * i want to set up curriculum for a faculty, 
 * so that i can manage schedule by program.
 * @author zaida
 */

@JGivenStage
public class WhenIWantToSetUpCurriculumForAFaculty extends Stage<WhenIWantToSetUpCurriculumForAFaculty> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetUpCurriculumForAFaculty.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdProgram program;

	public WhenIWantToSetUpCurriculumForAFaculty I_set_up_curriculum_for_that_program() {
		// setting up curriculum
		AdCurriculum curriculum = new AdCurriculumImpl();
		curriculum.setCode(program.getCode() + "/CRLM/0002");
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

		return self();

	}
}
