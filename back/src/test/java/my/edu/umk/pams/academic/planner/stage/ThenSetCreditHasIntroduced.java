package my.edu.umk.pams.academic.planner.stage;

/**
 * @author zaida_Ain
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;

public class ThenSetCreditHasIntroduced extends Stage<ThenSetCreditHasIntroduced> {

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@Autowired
	private PlannerService plannerService;

	private static final Logger LOG = LoggerFactory.getLogger(ThenSetCreditHasIntroduced.class);

	public ThenSetCreditHasIntroduced set_credit_has_introduced() {

		LOG.debug("academicSession {} ", academicSession);
		// AdAcademicSession academicSession =
		// plannerService.findCurrentAcademicSession();
		Assert.notNull(academicSession, "The data must not be null");

		return self();

	}

}
