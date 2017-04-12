package my.edu.umk.pams.academic.term.stage;

/**
 * @author asyikin.mr 
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdSection;

@JGivenStage
public class ThenTheEnrollmentDateIsOpen extends Stage<ThenTheEnrollmentDateIsOpen> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentDateIsOpen.class);

	@Autowired
	private SystemService systemService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdSection section;

	public ThenTheEnrollmentDateIsOpen the_enrollment_date_is_open() {

		Assert.notNull(section, "section should be not null");

		// updated section data
		LOG.debug("section id:{}", section.getId());
		LOG.debug("Updated capacity section: {}", section.getCapacity());
		LOG.debug("Updated ordinal section: {}", section.getOrdinal());

		AdConfiguration configuration = systemService
				.findConfigurationByKey(AcademicConstants.ENROLLMENT_STARTDATE_OPEN);
		systemService.saveConfiguration(configuration);
		LOG.debug("Save value: {}", configuration.getValue());

		return self();
	}
}
