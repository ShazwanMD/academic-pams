/**
 * @author asyikin.mr and ziana


 */
package my.edu.umk.pams.academic.term.stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIUpdateSections extends Stage<WhenIUpdateSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateSections.class);

	@Autowired
	private TermService termService;
	
	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdSection section;
	
	@ProvidedScenarioState
	private AdOffering offering;
	
	@ProvidedScenarioState
	private String canonical_code;
	
	@ExpectedScenarioState
	private List<AdProgram> programs;
	
	@ProvidedScenarioState
	private List<AdOffering> offerings;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdProgram program;

	public WhenIUpdateSections I_update_sections_$_for_offering(String code) {
		
		Assert.notNull(code, "code should be not null");
		LOG.debug("section code: {}", code);
		
		// find faculty of the program
		LOG.debug("Pick faculty: {}", faculty.getCode());
		
		//find program under selected faculty
		programs = plannerService.findPrograms(faculty);
		LOG.debug("=======Lists of program========");
		for (AdProgram program : programs) {
			
			LOG.debug("program: {}", program.getTitleEn());
			LOG.debug("code: {}", program.getCode());
		}
		
		//find offering under selected program
		offerings = termService.findOfferings(program);
		LOG.debug("=======Lists of offering========");
		for (AdOffering offering : offerings) {
			
			LOG.debug("offering: {}", offering.getTitle());
			LOG.debug("code: {}", offering.getCanonicalCode());
		}
		
		//select offering code from list of offerings
		offering= termService.findOfferingByCanonicalCode("MGSEB-MBA-GST5023");
		Assert.notNull(offering, "offering should be not null");
		LOG.debug("offering: {}", offering.getCanonicalCode());
	
		section = termService.findSectionByCanonicalCode(code);
		Assert.notNull(section, "section should be not null");
		
		//current section data
		LOG.debug("=======current section data for offering  " + offering.getCanonicalCode() + "=======");
		LOG.debug("Current CanonicalCode: {}", section.getCanonicalCode());
		LOG.debug("Current Capacity: {}", section.getCapacity());
		LOG.debug("Current Ordinal: {}", section.getOrdinal());
		
		//update section to new capacity and ordinal
		section.setCode("GST5023");
		section.setCanonicalCode(code);
		section.setOrdinal(1);
		section.setCapacity(30);
		section.setOffering(offering);
		section.setSession(academicSession);
			
		termService.updateSection(section);
		
		//new updated section data
		LOG.debug("===========updated section data=============");
		LOG.debug("New updated section capacity: {}", section.getCapacity());
		LOG.debug("New updated section ordinal: {}", section.getOrdinal());

		return self();
	}
}
