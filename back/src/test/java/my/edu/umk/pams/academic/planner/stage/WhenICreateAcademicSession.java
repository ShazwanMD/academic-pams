package my.edu.umk.pams.academic.planner.stage;

/** 
 * todo: zaida (check with AcademicSessionImpl for previous_id and year_id which is must be not null)

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
public class WhenICreateAcademicSession extends Stage<WhenICreateAcademicSession> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenICreateAcademicSession.class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private String code;
	

	public WhenICreateAcademicSession I_create_academic_session() {

		//AdAcademicYear academicYear = ""; 
		//AdAcademicSession previous = "";
		academicSession = new AdAcademicSessionImpl();
		academicSession.setCode("201820191");
		academicSession.setDescription("SESSION 201820191");
		academicSession.setStartDate(new Date());
		academicSession.setEndDate(new Date());
		academicSession.setStatus(AdAcademicStatus.NEW);
		academicSession.setCurrent(true);
		academicSession.setSemester(AdAcademicSemester.SEMESTER_1);
		//academicSession.setPrevious(previous);
		//academicSession.setYear(academicYear);
		
		
		
		plannerService.updateAcademicSession(academicSession);
		LOG.debug("academicSession {} ", academicSession);

		return self();
	}
}
