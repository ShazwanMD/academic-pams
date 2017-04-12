package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
/**
 * @author zaida_nawi
 **/

@JGivenStage
public class WhenICloseTheEnrollmentDate extends Stage<WhenICloseTheEnrollmentDate> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewTheOfferedCourses.class);

	@Autowired
	private SystemService systemService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdOffering offering;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public WhenICloseTheEnrollmentDate I_close_the_date_of_enrollment_for_program_$(String programCode) {

		academicSession = plannerService.findAcademicSessionByCode("201820181");
		List<AdSection> sections = termService.findSections(academicSession);

		for (AdSection section : sections) {
			LOG.debug(section.getCanonicalCode());
		}

		AdConfiguration configuration = systemService
				.findConfigurationByKey(AcademicConstants.ENROLLMENT_ENDDATE_CLOSE);
		configuration.setValue("20/05/2017");
		systemService.updateConfiguration(configuration);
		LOG.debug("value: {}", configuration.getValue());

		return self();

	}

}
