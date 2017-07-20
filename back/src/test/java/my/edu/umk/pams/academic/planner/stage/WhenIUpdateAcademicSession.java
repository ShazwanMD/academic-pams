
package my.edu.umk.pams.academic.planner.stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdAcademicSemester;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIUpdateAcademicSession extends Stage<WhenIUpdateAcademicSession> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAcademicSession.class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;
	
	private String startDate;
	private String endDate;

	
	public WhenIUpdateAcademicSession I_update_academic_session() {
		
		startDate = "01/04/2017";
		endDate = "10/04/2017";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date dateStart = null;
		try {
			dateStart = sdf.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dateEnd = null;
		try {
			dateEnd = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		};
		
		AdAcademicSession adAcademicSession = academicSession;
		
		adAcademicSession.setDescription("SESSION FEB 2017");
		adAcademicSession.setStartDate(dateStart);
		adAcademicSession.setEndDate(dateEnd);
		adAcademicSession.setSemester(AdAcademicSemester.SEMESTER_2);

		plannerService.updateAcademicSession(adAcademicSession);

		LOG.debug("academicSession Description : {} ", academicSession.getDescription());
		LOG.debug("academicSession StartDate: {} ", academicSession.getStartDate());
		LOG.debug("academicSession EndDate: {} ", academicSession.getEndDate());
		LOG.debug("academicSession Semester: {} ", academicSession.getSemester());

		// Return to original semester value
		adAcademicSession.setSemester(AdAcademicSemester.SEMESTER_1);
		plannerService.updateAcademicSession(adAcademicSession);

		return self();

	}

}