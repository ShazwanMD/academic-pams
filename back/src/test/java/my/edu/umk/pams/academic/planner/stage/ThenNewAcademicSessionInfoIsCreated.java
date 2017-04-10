//package my.edu.umk.pams.academic.planner.stage;

//public class ThenTheStatusIsUpdated {

//}

package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author zaida.n
 */
@JGivenStage
public class ThenNewAcademicSessionInfoIsCreated extends Stage<ThenNewAcademicSessionInfoIsCreated> {

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@Autowired
	private PlannerService plannerService;

	private static final Logger LOG = LoggerFactory.getLogger(ThenNewAcademicSessionInfoIsCreated.class);

	public ThenNewAcademicSessionInfoIsCreated New_academic_session_info_is_created() {

//		LOG.debug("academicSession {} ", academicSession);
//		Assert.notNull(academicSession, "The data must not be null");
		
		academicSession = plannerService.findAcademicSessionByCode("20192020");
		Assert.notNull(plannerService, "The data must not be null");

		return self();

	}
}
