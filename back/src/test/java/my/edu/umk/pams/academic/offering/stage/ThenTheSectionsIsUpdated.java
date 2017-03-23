package my.edu.umk.pams.academic.offering.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class ThenTheSectionsIsUpdated extends Stage<ThenTheSectionsIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheSectionsIsUpdated.class);
	@Autowired
	private OfferingService offeringService;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private String canonicalCode;

	public ThenTheSectionsIsUpdated the_sections_is_updated() {

		LOG.debug("section {} ", section.getCanonicalCode());
		
		AdSection section = offeringService.findSectionByCanonicalCode(canonicalCode);
		Assert.notNull(section, "The data must not be null");

		return self();

	}

}
