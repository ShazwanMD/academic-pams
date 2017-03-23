package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.model.AdSectionImpl;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author asyikin.mr and ziana
 */
@JGivenStage
public class WhenIUpdateSections extends Stage<WhenIUpdateSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateSections.class);

	@Autowired
	private OfferingService offeringService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdSection section;

	public WhenIUpdateSections I_update_sections_for_offering() {

		LOG.debug("section: {}", section.getCanonicalCode());

		section = new AdSectionImpl();
		section.setCapacity(20);
		section.setAppointmentCount(1);
		section.setEnrollmentCount(1);
		section.setOrdinal(1);

		offeringService.updateSection(section);

		return self();
	}

}
