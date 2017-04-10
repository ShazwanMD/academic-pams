package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenCohortIsAdded extends Stage<ThenCohortIsAdded> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenCohortIsAdded.class);

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdCohort cohort;

	public ThenCohortIsAdded cohort_is_added() {

		cohort = plannerService.findCohortByCode("FIAT/PHD/0001");
		Assert.notNull(plannerService, "Cohort should not be empty");
		return self();
	}

}
