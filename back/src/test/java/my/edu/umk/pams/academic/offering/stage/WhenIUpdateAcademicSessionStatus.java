package my.edu.umk.pams.academic.offering.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSemester;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicStatus;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicYear;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

import java.util.Calendar;

public class WhenIUpdateAcademicSessionStatus extends Stage<WhenIUpdateAcademicSessionStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAcademicSessionStatus.class);

	@Autowired
	private StudyplanService studyplanService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private String code;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdMetadata metadata;

	@ExpectedScenarioState
	private AdAcademicYear academicYear;

	@ExpectedScenarioState
	private AdAcademicSemester academicSemester;

	@ExpectedScenarioState
	private AdAcademicSession previous;

	public WhenIUpdateAcademicSessionStatus I_update_academic_session_status() {

		Calendar now = Calendar.getInstance();
		code = (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);
   // to do asyikin and uda tolong tengok tak siap lagi =)
		academicSession = new AdAcademicSessionImpl();
		academicSession.setCode(code);
		academicSession.setCurrent(true);
		academicSession.setDescription("Sesi 09/2017/2018");
		academicSession.setEndDate(null);
		academicSession.setMetadata(metadata);
		academicSession.setPrevious(previous);
		academicSession.setStatus(AdAcademicStatus.NEW);
		academicSession.setStartDate(null);
		academicSession.setYear(academicYear);
		academicSession.setSemester(academicSemester);

		studyplanService.updateAcademicSession(academicSession);

		LOG.debug("academicSession {} ", academicSession);
		return self();
	}
}
