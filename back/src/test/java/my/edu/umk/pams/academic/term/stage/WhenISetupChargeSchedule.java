package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.term.model.AdChargeScheduleImpl;
import my.edu.umk.pams.academic.term.service.TermService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static my.edu.umk.pams.academic.AcademicConstants.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@JGivenStage
public class WhenISetupChargeSchedule extends Stage<WhenISetupChargeSchedule> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenISetupChargeSchedule.class);

	@Autowired
	private TermService termService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdCohort cohort;

	@ExpectedScenarioState
	private AdStudyCenter center;

	@ProvidedScenarioState
	private String cohortCode;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private AdChargeSchedule schedule; 

	private AdCurriculum getCurriculum() {
		Assert.notNull(program, "program cannot be null");
		LOG.debug("Program code: {}", program.getId());

		List<AdCurriculum> curriculums = plannerService.findCurriculums(program);
		LOG.debug("curriculums: {}", curriculums);
		Assert.notEmpty(curriculums, "curriculums cannot be empty");
		return curriculums.get(0); // TODO: Flakey get first, should get object
									// explicitly
	}

	private AdCohort prepareCohort(String cohortCode) {
		Assert.notNull(cohortCode, "cohortCode cannot be null");

		cohort = new AdCohortImpl();
		cohort.setCode("FIAT-PHD-PBB-CHRT-201720182");
		cohort.setDescription("COHORT 003");
		cohort.setClassification(AdAcademicClassification.LEVEL_GRADUATED);
		cohort.setProgram(program);
		cohort.setSession(academicSession);
		cohort.setCurriculum(getCurriculum());

		plannerService.saveCohort(cohort);
		return cohort;
	}

	private void prepareStudyCenter() {
		center = new AdStudyCenterImpl();
		center.setCode("F");
		center.setDescription("KAMPUS SARAWAK");
		commonService.saveStudyCenter(center);

	}

	private void prepareDependencies(String cohortCode) {
		Assert.notNull(cohortCode, "cohortCode cannot be null");

		prepareCohort(cohortCode);
		Assert.notNull(cohort, "cohort cannot be null");

		prepareStudyCenter();
		Assert.notNull(center, "center cannot be null");

		Assert.notNull(program, "program cannot be null");
	}

	public WhenISetupChargeSchedule I_setup_charge_schedule_for_cohort_$(String cohortCode) {
		prepareDependencies(cohortCode);

		LOG.debug("faculty: {}", faculty.getId());
		LOG.debug("program: {}", program.getId());
		LOG.debug("cohortCode: {}", cohortCode);

		cohort = plannerService.findCohortByCode(cohortCode);
		Assert.notNull(cohort, "cohort cannot be null");
		
		center = commonService.findStudyCenterByCode("A");
		Assert.notNull(center, "center cannot be null");

		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(CHARGE_SCHEDULE_CODE, param);

		//insert new charge schedule
		schedule = new AdChargeScheduleImpl();
		schedule.setAmount(new BigDecimal("150.00"));
		schedule.setCode(refNo);
		schedule.setPeriod(AdAcademicPeriod.I);
		schedule.setProgram(program);
		schedule.setStudyCenter(center);
		schedule.setCohort(cohort);

		termService.saveSchedule(schedule);
		
		Assert.notNull(schedule, "schedule cannot be null");

		LOG.debug("==========view data after insert new========");
		LOG.debug("schedule id: {}", schedule.getId());
		LOG.debug("cohort: {}", schedule.getCohort().getId());
		LOG.debug("program: {}", schedule.getProgram().getId());
		LOG.debug("amount: {}", schedule.getAmount());
		LOG.debug("studyCenter: {}", schedule.getStudyCenter().getCode());
		LOG.debug("period: {}", schedule.getPeriod());
		LOG.debug("code: {}", schedule.getCode());

		return self();
	}
	
	public WhenISetupChargeSchedule I_update_charge_schedule_for_cohort_$(String cohortCode) {
	
			
		// setup params for refno generation
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("academicSession", plannerService.findCurrentAcademicSession());
		String refNo = systemService.generateFormattedReferenceNo(CHARGE_SCHEDULE_CODE, param);
		
		//update charge schedule
		schedule.setAmount(new BigDecimal("190.00"));
		schedule.setCode(refNo);
		schedule.setPeriod(AdAcademicPeriod.II);
		schedule.setProgram(program);
		schedule.setStudyCenter(center);
		schedule.setCohort(cohort);

		termService.updateSchedule(schedule);

		Assert.notNull(schedule, "schedule cannot be null");
		
		LOG.debug("==========view data after update new========");
		LOG.debug("schedule id: {}", schedule.getId());
		LOG.debug("cohort: {}", schedule.getCohort().getId());
		LOG.debug("program: {}", schedule.getProgram().getId());
		LOG.debug("amount: {}", schedule.getAmount());
		LOG.debug("studyCenter: {}", schedule.getStudyCenter().getCode());
		LOG.debug("period: {}", schedule.getPeriod());
		LOG.debug("code: {}", schedule.getCode());
		
		return self();
	}
}