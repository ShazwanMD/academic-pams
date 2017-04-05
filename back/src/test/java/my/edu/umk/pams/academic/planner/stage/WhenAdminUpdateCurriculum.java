package my.edu.umk.pams.academic.planner.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.common.service.CommonService;

import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

public class WhenAdminUpdateCurriculum extends Stage<WhenAdminUpdateCurriculum> {

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	public WhenAdminUpdateCurriculum Admin_update_curriculum_$(String Code) {

		return self();
	}
}