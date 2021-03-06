package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.service.TermService;

@Deprecated
@JGivenStage
public class ThenTheChargeScheduleIsReviewed extends Stage<ThenTheChargeScheduleIsReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheChargeScheduleIsReviewed.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdProgram program;
	
	public ThenTheChargeScheduleIsReviewed the_charge_schedule_is_reviewed() {

		// process view charge schedule in db
		LOG.debug("============review data============");
//		LOG.debug("schedule id: {}", schedule.getId());
//		LOG.debug("cohort: {}", schedule.getCohort().getId());
//		LOG.debug("program: {}", schedule.getProgram().getId());
//		LOG.debug("amount: {}", schedule.getAmount());
//		LOG.debug("studyCenter: {}", schedule.getStudyCenter().getCode());
//		LOG.debug("period: {}", schedule.getOrdinal());
//		LOG.debug("code: {}", schedule.getCode());

		return self();
	}
}