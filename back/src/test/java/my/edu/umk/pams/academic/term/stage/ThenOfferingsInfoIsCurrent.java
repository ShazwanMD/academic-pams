package my.edu.umk.pams.academic.term.stage;

import java.util.List;

/**
 * @author asyikin.mr and ZIANA
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenOfferingsInfoIsCurrent extends Stage<ThenOfferingsInfoIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenOfferingsInfoIsCurrent.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdOffering offering;

	public ThenOfferingsInfoIsCurrent the_offerings_info_is_current() {

		LOG.debug("Program:{}", program.getCode());
				
		List<AdOffering> offerings = termService.findOfferings(program);

		for (AdOffering offering : offerings) {

			Assert.notNull(offering, "Offering data should be not null");
			LOG.debug("View updated code: {}", offering.getCanonicalCode());
			LOG.debug("View updated title: {}", offering.getTitle());
			LOG.debug("Listed updated capacity: {}", offering.getCapacity());

		}

		return self();
	}
}
