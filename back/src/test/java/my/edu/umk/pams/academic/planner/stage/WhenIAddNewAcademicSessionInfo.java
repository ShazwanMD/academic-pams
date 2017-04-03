package my.edu.umk.pams.academic.planner.stage;

/**
 * @author zaida.n
 */

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSemester;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicStatus;
import my.edu.umk.pams.academic.planner.model.AdAcademicYear;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

@JGivenStage
public class WhenIAddNewAcademicSessionInfo extends Stage<WhenIAddNewAcademicSessionInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAddNewAcademicSessionInfo.class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private String code;

	public WhenIAddNewAcademicSessionInfo I_add_new_academic_session_info() {

		// AdAcademicYear academicYear = "";
		// AdAcademicSession previous = "";
		academicSession = new AdAcademicSessionImpl();
		academicSession.setCode("20192020");
		academicSession.setDescription("SESSION 20182019100");
		academicSession.setStartDate(new Date());
		academicSession.setEndDate(new Date());
		academicSession.setStatus(AdAcademicStatus.NEW);
		academicSession.setCurrent(true);
		academicSession.setSemester(AdAcademicSemester.SEMESTER_2);
		// academicSession.setPrevious(previous);
		// academicSession.setYear(academicYear);

		plannerService.saveAcademicSession(academicSession);
		LOG.debug("academicSession {} ", academicSession);

		return self();
	}

}
