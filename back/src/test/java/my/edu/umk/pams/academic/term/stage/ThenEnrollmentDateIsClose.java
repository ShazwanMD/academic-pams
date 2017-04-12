package my.edu.umk.pams.academic.term.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
/**
 * @author zaida_nawi
 **/

@JGivenStage
public class ThenEnrollmentDateIsClose extends Stage<ThenEnrollmentDateIsClose> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenEnrollmentDateIsClose.class);
	


	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private SystemService systemService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public ThenEnrollmentDateIsClose Enrollment_date_is_close() {

		
		academicSession = plannerService.findAcademicSessionByCode("201820181");
		List<AdSection> sections = termService.findSections(academicSession);
		
		return self();

	}

}