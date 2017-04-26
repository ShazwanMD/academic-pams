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
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.term.model.AdChargeScheduleImpl;
import my.edu.umk.pams.academic.term.service.TermService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@JGivenStage
public class WhenISetupChargeSchedule extends Stage<WhenISetupChargeSchedule> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenISetupChargeSchedule.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdStudyCenter center;
	
	@ProvidedScenarioState
	private String cohortCode;
	
	@ProvidedScenarioState
	private AdAcademicSession session;
	
	
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
		cohort.setCode("FIAT/PHD/PBT/CHRT/201720182");
		cohort.setDescription("COHORT 002");
		cohort.setClassification(AdAcademicClassification.LEVEL_GRADUATED);
		cohort.setProgram(program);
		cohort.setSession(session);
		cohort.setCurriculum(getCurriculum());
		
		plannerService.saveCohort(cohort);
		return cohort;
	}

	private void prepareStudyCenter() {
		center = new AdStudyCenterImpl();
		center.setCode("E");
		center.setDescription("KAMPUS KUCHING");
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

			
		LOG.debug("faculty: {}",faculty.getId() );
		LOG.debug("program: {}", program.getId());
		LOG.debug("cohortCode: {}", cohortCode);
		
		AdCohort cohort = plannerService.findCohortByCode(cohortCode);
		AdStudyCenter center  = commonService.findStudyCenterByCode("A");
		
		AdChargeSchedule schedule = new AdChargeScheduleImpl();
		schedule.setAmount(new BigDecimal("150.00"));
		schedule.setCode(cohortCode + "/" + "001" );
		schedule.setPeriod(AdAcademicPeriod.I);
		schedule.setProgram(program);
		schedule.setStudyCenter(center);
		schedule.setCohort(cohort);

		termService.saveSchedule(schedule);
		
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
}