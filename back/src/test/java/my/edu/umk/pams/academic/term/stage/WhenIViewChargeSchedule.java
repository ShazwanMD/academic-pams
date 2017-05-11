package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.HashMap;

import static my.edu.umk.pams.academic.AcademicConstants.CHARGE_SCHEDULE_CODE;

@Deprecated
@JGivenStage
public class WhenIViewChargeSchedule extends Stage<WhenIViewChargeSchedule> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewChargeSchedule.class);
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private TermService termService;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdCohort cohort; 
	
	@ProvidedScenarioState
	private AdStudyCenter center; 
	
	@ProvidedScenarioState
	private String refNo;
	
	public WhenIViewChargeSchedule I_add_charge_schedule_for_cohort_$(String cohortCode) {

		LOG.debug("cohortCode: {}", cohortCode);
		LOG.debug("program: {}", program.getCode());
				
		Assert.notNull(cohortCode, "cohortCode cannot be null");
		cohort = plannerService.findCohortByCode(cohortCode);
		center = commonService.findStudyCenterByCode("A");

		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		refNo = systemService.generateFormattedReferenceNo(CHARGE_SCHEDULE_CODE, param);
					
		return self();
	}
		
	public WhenIViewChargeSchedule I_view_charge_schedule_for_cohort_$(String cohortCode) {
		
		LOG.debug("==============view new data inserted==============");
		Assert.notNull(cohortCode, "cohortCode cannot be null");
		LOG.debug("cohortCode: {}", cohortCode);
		
		return self();
	}
	
}


