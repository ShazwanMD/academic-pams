/**
 * @author asyikin.mr and ziana

 */
package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIUpdateSections extends Stage<WhenIUpdateSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateSections.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdSection section;
	
	@ProvidedScenarioState
	private AdOffering offering;
	
	@ProvidedScenarioState
	private String canonical_code;

	public WhenIUpdateSections I_update_sections_for_offering() {
		
		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		offering= termService.findOfferingByCanonicalCode("A01/PHD/0001/DDA2113");
		
		LOG.debug("section: {}", section.getCanonicalCode());
		LOG.debug("offering: {}", offering.getCanonicalCode());
		
		//current section data
		LOG.debug("Current data section: {}", section.getCanonicalCode());
		LOG.debug("Current data section: {}", section.getCapacity());
		LOG.debug("Current data section: {}", section.getOrdinal());
		
		//update section to new capacity and ordinal
		section.setCode("DDA2113");
		section.setCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		section.setOrdinal(1);
		section.setCapacity(30);
		section.setOffering(offering);
		section.setSession(academicSession);
			
		termService.updateSection(section);
		
		//new updated section data
		LOG.debug("New updated section capacity: {}", section.getCapacity());
		LOG.debug("New updated section ordinal: {}", section.getOrdinal());

		return self();
	}
}
