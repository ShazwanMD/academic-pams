package my.edu.umk.pams.academic.planner.stage;

/*Given : I Am Admin
When : Admin Update Cohort 
Then :  New Cohort Is Updated.
@author zaida_n
*/

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateCohort extends Stage<WhenAdminUpdateCohort> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateCohort.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	@ProvidedScenarioState
	private AdCohort cohort;

	public WhenAdminUpdateCohort Admin_update_cohort_to_faculty_code_$(String Code) {

		program = plannerService.findProgramByCode(Code);
		LOG.debug("program code: {}", program.getCode());

		AdCohort cohort = plannerService.findCohortByCode("A08/PHD/0006/CHRT/0001");
		LOG.debug("cohort: {}", cohort.getDescription());

		cohort.setCode("/CHRT/2019");
		cohort.setDescription("FIRSTt COHORTll FOR PROGRAM ");
		cohort.setClassification(AdAcademicClassification.LEVEL_000);
		cohort.setCurriculum(curriculum);
		cohort.setProgram(program);
		plannerService.updateCohort(cohort);

		return self();
	}
}