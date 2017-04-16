package my.edu.umk.pams.academic.term.stage;

/**
 * @author asyikin.mr 
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIOpenTheEnrollmentDate extends Stage<WhenIOpenTheEnrollmentDate> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIOpenTheEnrollmentDate.class);

	@Autowired
	private SystemService systemService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public WhenIOpenTheEnrollmentDate I_open_the_date_of_enrollment_for_program_$(String code) {

		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		Assert.notNull(section, "section should be not null");

		// current section data
		LOG.debug("section id:{}", section.getId());
		LOG.debug("capacity section: {}", section.getCapacity());
		LOG.debug("ordinal section: {}", section.getOrdinal());

		AdConfiguration configuration = systemService.findConfigurationByKey(AcademicConstants.ENROLLMENT_STARTDATE_OPEN);
		configuration.setValue("30/04/2017");
		systemService.updateConfiguration(configuration);
		LOG.debug("Updated value: {}", configuration.getValue());

		return self();

	}
}
