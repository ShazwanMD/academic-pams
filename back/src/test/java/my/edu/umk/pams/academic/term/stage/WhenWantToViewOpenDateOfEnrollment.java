package my.edu.umk.pams.academic.term.stage;
/**
 * @author zaida_nawi
 **/

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenWantToViewOpenDateOfEnrollment extends Stage<WhenWantToViewOpenDateOfEnrollment> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenWantToViewOpenDateOfEnrollment.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private SystemService systemService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdConfiguration configuration;

	public WhenWantToViewOpenDateOfEnrollment Want_to_view_open_date_of_enrollment() {

		// section =
		// termService.findSectionByCanonicalCode("FIAT/MASTER/PBH/GST5023/201720181");
		// Assert.notNull(section, "section should be not null");
		// AdOffering offering =
		// termService.findOfferingByCanonicalCode("FIAT/MASTER/PBH/GST5023");

		// section =
		// termService.findSectionByCanonicalCode("FIAT/MASTER/PBH/GST5023/201720181");
		// Assert.notNull(section, "section should be not null");

		// LOG.debug("section id:{}", section.getId());
		// LOG.debug("capacity section: {}", section.getCapacity());
		// LOG.debug("ordinal section: {}", section.getOrdinal());

		configuration = systemService.findConfigurationByKey(AcademicConstants.ENROLLMENT_STARTDATE_OPEN);
		//configuration.setValue("30/04/2017");
		systemService.updateConfiguration(configuration);
		LOG.debug("description : {}", configuration.getDescription());
		LOG.debug("Open Enrollment Date : {}", configuration.getValue());

		return self();
	}
}
