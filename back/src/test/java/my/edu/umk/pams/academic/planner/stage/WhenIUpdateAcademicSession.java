
package my.edu.umk.pams.academic.planner.stage;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdAcademicSemester;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;


public class WhenIUpdateAcademicSession extends Stage<WhenIUpdateAcademicSession> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAcademicSession .class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private String code;
	
	public WhenIUpdateAcademicSession I_update_academic_session() {
		
		academicSession = new AdAcademicSessionImpl();
		academicSession.setCode("201820191");
		academicSession.setDescription("SESSION FEB 2017");
		academicSession.setStartDate(new Date());
		academicSession.setEndDate(new Date());
		academicSession.setStatus(AdAcademicStatus.NEW);
		academicSession.setCurrent(true);
		academicSession.setSemester(AdAcademicSemester.SEMESTER_2);
		
		plannerService.updateAcademicSession(academicSession);
		LOG.debug("academicSession {} ", academicSession);
		
		return self();
		
	}

}