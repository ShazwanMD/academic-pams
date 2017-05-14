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
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
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

	@ExpectedScenarioState
	private AdCurriculum curriculum;

	@ProvidedScenarioState
	private AdCohort cohort;
	
	@ExpectedScenarioState
	private AdFaculty faculty;

	public WhenAdminUpdateCohort Admin_update_cohort_to_faculty_code_$(String code) {
		
		
		program = plannerService.findProgramByCode("FIAT-PHD-PBT");
		LOG.debug("program code: {}", program.getCode());

		AdCohort cohort = plannerService.findCohortByCode(code);
		LOG.debug("cohort code: {}", cohort.getCode());

		cohort.setCode(code);
		cohort.setDescription("FIRST COHORT");
		cohort.setClassification(AdAcademicClassification.LEVEL_000);
		cohort.setCurriculum(curriculum);
		cohort.setProgram(program);
		plannerService.updateCohort(cohort);
		
		LOG.debug("cohort code: {}", cohort.getCode());
		LOG.debug("cohort desription: {}", cohort.getDescription());
		LOG.debug("cohort Classification: {}", cohort.getClassification());
		
		
		
		return self();
	}
}