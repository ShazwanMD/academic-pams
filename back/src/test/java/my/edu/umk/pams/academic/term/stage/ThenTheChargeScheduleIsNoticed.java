package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.term.model.AdChargeSchedule;

@JGivenStage
public class ThenTheChargeScheduleIsNoticed extends Stage<ThenTheChargeScheduleIsNoticed> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheChargeScheduleIsNoticed.class);
	
	@ExpectedScenarioState
	private AdChargeSchedule schedule;
	
	public ThenTheChargeScheduleIsNoticed the_charge_schedule_is_noticed() {

		// process view charge schedule in db
		Assert.notNull(schedule, "schedule cannot be null");
		
		LOG.debug("==============charge schedule is reviewed for futher action==============");
		LOG.debug("schedule id: {}", schedule.getId());
		LOG.debug("Ref. No: {}", schedule.getCode());
		LOG.debug("Academic Period: {}", schedule.getPeriod());
		LOG.debug("StudyCenter: {}", schedule.getStudyCenter().getDescription());
		LOG.debug("Cohort: {}", schedule.getCohort().getCode());
		LOG.debug("Program: {}", schedule.getProgram().getTitleEn());
		
		
		return self();
	}
}