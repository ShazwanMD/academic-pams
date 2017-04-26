package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIViewChargeSchedule extends Stage<WhenIViewChargeSchedule> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewChargeSchedule.class);
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdFaculty faculty;
	
	@ProvidedScenarioState
	private AdCohort cohort; 
	
	
	
	
	@Pending
	public WhenIViewChargeSchedule I_view_charge_schedule_for_cohort_$(String cohortCode) {

		cohort = plannerService.findCohortByCode(cohortCode);
		
		Assert.notNull(cohort, "cohort cannot be null");
		LOG.debug("cohort id: {}", cohort.getId());
		
		AdChargeSchedule schedule = termService.findScheduleByCode(cohortCode);
		Assert.notNull(schedule, "schedule cannot be null");
		LOG.debug("schedule id: {}", schedule.getId());
		LOG.debug("schedule id: {}", schedule.getCode());
		LOG.debug("schedule id: {}", schedule.getPeriod());
		
		
		return self();
	}
}
