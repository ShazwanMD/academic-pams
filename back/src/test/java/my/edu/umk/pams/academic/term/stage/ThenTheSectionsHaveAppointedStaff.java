package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.service.OfferingService;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class ThenTheSectionsHaveAppointedStaff extends Stage<ThenTheSectionsHaveAppointedStaff> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheSectionsHaveAppointedStaff.class);

	@Autowired
	private OfferingService offeringService;

	@ExpectedScenarioState
	private AdAppointment appointment;
	
	@ExpectedScenarioState
	private String canonicalCode;

	public ThenTheSectionsHaveAppointedStaff the_sections_have_appointed_staff() {
		LOG.debug("appointment {} ", appointment.getStaff());
		 
		AdAppointment appointment = (AdAppointment) offeringService.findSectionByCanonicalCode(canonicalCode);
		Assert.notNull(appointment, "The data must not be null");

		return self();
	}
}
