package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;

import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdCurriculumImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateCurriculum extends Stage<WhenAdminUpdateCurriculum> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateCurriculum.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdCurriculum curriculum;

	public WhenAdminUpdateCurriculum Admin_update_curriculum_$(String Code) {

		curriculum = plannerService.findCurriculumByCode("A07/PHD/0001/CRLM/0001");

		
		// setting up curriculum
		curriculum.setCode("A07/PHD/0001/CRLM/CRLM/0003");
		curriculum.setOrdinal(1);
		curriculum.setCoreCredit(2);
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

		plannerService.updateCurriculum(curriculum);

		LOG.debug("curriculum : {}", curriculum.getCode());

		return self();
	}
}