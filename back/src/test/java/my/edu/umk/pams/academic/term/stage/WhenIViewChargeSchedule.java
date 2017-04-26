package my.edu.umk.pams.academic.term.stage;

import static my.edu.umk.pams.academic.AcademicConstants.CHARGE_SCHEDULE_CODE;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdAcademicPeriod;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.term.model.AdChargeScheduleImpl;
import my.edu.umk.pams.academic.term.service.TermService;

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
	private AdChargeSchedule schedule;
/*	
	private AdChargeSchedule prepareSchedule(String cohortCode) {
		Assert.notNull(cohortCode, "cohortCode cannot be null");
		AdCohort cohort = plannerService.findCohortByCode(cohortCode);
		AdStudyCenter center = commonService.findStudyCenterByCode("B");

		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(CHARGE_SCHEDULE_CODE, param);

		schedule = new AdChargeScheduleImpl();
		schedule.setAmount(new BigDecimal("150.00"));
		schedule.setCode(refNo);
		schedule.setPeriod(AdAcademicPeriod.II);
		schedule.setProgram(program);
		schedule.setStudyCenter(center);
		schedule.setCohort(cohort);

		termService.saveSchedule(schedule);
		return schedule;
	}
	
	private AdChargeSchedule prepareSchedule(String cohortCode) {
		
		Assert.notNull(cohortCode, "cohortCode cannot be null");
		AdCohort cohort = plannerService.findCohortByCode(cohortCode);
		AdStudyCenter center = commonService.findStudyCenterByCode("B");

		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(CHARGE_SCHEDULE_CODE, param);

		schedule = new AdChargeScheduleImpl();
		schedule.setAmount(new BigDecimal("150.00"));
		schedule.setCode(refNo);
		schedule.setPeriod(AdAcademicPeriod.II);
		schedule.setProgram(program);
		schedule.setStudyCenter(center);
		schedule.setCohort(cohort);

		termService.saveSchedule(schedule);
		
		return schedule;

	}
*/	

	@Pending
	public WhenIViewChargeSchedule I_view_charge_schedule_for_cohort_$(String cohortCode) {

		LOG.debug("cohortCode: {}", cohortCode);
		LOG.debug("program: {}", program.getCode());
		
		
		Assert.notNull(cohortCode, "cohortCode cannot be null");
		AdCohort cohort = plannerService.findCohortByCode(cohortCode);
		AdStudyCenter center = commonService.findStudyCenterByCode("B");

		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(CHARGE_SCHEDULE_CODE, param);

		schedule = new AdChargeScheduleImpl();
		schedule.setAmount(new BigDecimal("150.00"));
		schedule.setCode(refNo);
		schedule.setPeriod(AdAcademicPeriod.II);
		schedule.setProgram(program);
		schedule.setStudyCenter(center);
		schedule.setCohort(cohort);

		termService.saveSchedule(schedule);
		
		schedule = termService.findScheduleByCode(cohortCode);
		Assert.notNull(schedule, "schedule cannot be null");
		
		LOG.debug("==============view new data==============");
		LOG.debug("schedule id: {}", schedule.getId());
		LOG.debug("schedule id: {}", schedule.getCode());
		LOG.debug("schedule id: {}", schedule.getPeriod());
				
		return self();
	}
}
