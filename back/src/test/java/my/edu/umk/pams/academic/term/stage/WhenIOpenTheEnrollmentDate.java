package my.edu.umk.pams.academic.term.stage;
/**
 * @author asyikin.mr 
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@Pending
public class WhenIOpenTheEnrollmentDate extends Stage<WhenIOpenTheEnrollmentDate> {
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

	public WhenIOpenTheEnrollmentDate I_open_the_date_of_enrollment_for_program_$(String code) {

		academicSession = plannerService.findAcademicSessionByCode("201720181");
		List<AdSection> sections = termService.findSections(academicSession);

		for (AdSection section : sections) {
			LOG.debug(section.getCanonicalCode());
		}

		AdConfiguration configuration = systemService
				.findConfigurationByKey(AcademicConstants.ENROLLMENT_STARTDATE_OPEN);
		configuration.setValue("30/04/2017");
		systemService.updateConfiguration(configuration);
		LOG.debug("value: {}", configuration.getValue());

		return self();

	}
}
