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
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@Pending
public class ThenTheEnrollmentDateIsOpen extends Stage<ThenTheEnrollmentDateIsOpen> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentDateIsOpen.class);
	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private SystemService systemService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public ThenTheEnrollmentDateIsOpen the_enrollment_date_is_open() {

		academicSession = plannerService.findAcademicSessionByCode("201720181");
		List<AdSection> sections = termService.findSections(academicSession);

		for (AdSection section : sections) {
			LOG.debug(section.getCanonicalCode());
		}

		AdConfiguration configuration = systemService
				.findConfigurationByKey(AcademicConstants.ENROLLMENT_STARTDATE_OPEN);
		systemService.saveConfiguration(configuration);

		return self();
	}
}
