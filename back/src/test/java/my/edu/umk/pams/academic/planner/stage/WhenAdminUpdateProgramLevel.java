package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;

import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.model.AdProgramLevelImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramType;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateProgramLevel extends Stage<WhenAdminUpdateProgramLevel> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateProgramLevel.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdProgramLevel programLevel;

	@ProvidedScenarioState
	private AdProgramType programType;

	public WhenAdminUpdateProgramLevel Admin_update_program_level(String code) {

		programLevel = plannerService.findProgramLevelByCode(code);
		
		programLevel.setType(programType.MASTER);
		programLevel.setCode("NEW MASTER");
		programLevel.setDescription("CURRENT");
		plannerService.updateProgramLevel(programLevel);

		LOG.debug("program level type: {}", programType.MASTER);
		LOG.debug("program level code : {}", programLevel.getCode());
		LOG.debug("program level description : {}", programLevel.getDescription());

		return self();

	}

}
