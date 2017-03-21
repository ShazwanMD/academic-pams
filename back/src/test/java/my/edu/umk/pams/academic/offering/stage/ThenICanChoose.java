package my.edu.umk.pams.academic.offering.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdEnrollment;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import org.springframework.util.Assert;

@JGivenStage
public class ThenICanChoose extends Stage<ThenICanChoose> {

	@Autowired
	private OfferingService offeringService;

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdOffering offering;

	@ExpectedScenarioState
	private AdSection section;

	private static final Logger LOG = LoggerFactory.getLogger(ThenICanChoose.class);

	public ThenICanChoose i_can_choose() {

		String canonicalCode = "123";
		LOG.debug("section {} ", section);
		AdSection section = offeringService.findSectionByCanonicalCode(canonicalCode);
		Assert.notNull(section, "The data must not be null");

		offering.getCourse().getCode();

		return self();

	}

}
