package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicYear;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class WhenIGenerateMatricNo extends Stage<WhenIGenerateMatricNo> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIGenerateMatricNo.class);
	
	@Autowired
	private IdentityService identityService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private PlannerService plannerService;
	
	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdCohort cohort;
	
	@ProvidedScenarioState
	private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private AdFaculty fromFaculty;
	
	@ProvidedScenarioState
	private AdAcademicYear year;
	
	@ProvidedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdStudyMode studyMode;
	
	
	public WhenIGenerateMatricNo i_generate_new_matricNo() {

	/*	
		student = identityService.findStudentByMatricNo("F17P0001P");
		studyMode = student.getStudyMode();
		LOG.debug("StudyMode Old :{}", studyMode.getPrefix());
		
		AdFaculty fromFaculty = student.getCohort().getProgram().getFaculty();
		fromFaculty.getPrefix();
		AdFaculty toFaculty = student.getCohort().getProgram().getFaculty();
		toFaculty.setPrefix("H");
		
		profileService.transferFaculty(student, session, fromFaculty, toFaculty);*/
		
		
		student = identityService.findStudentByMatricNo("A17M0001F");
		cohort = student.getCohort();
		academicSession = cohort.getSession();
		year = academicSession.getYear();
		LOG.debug("YEAR :{}", year.getYear());
		
		AdStudyMode fromMode = student.getStudyMode();
		LOG.debug("StudyMode Old :{}", fromMode.getPrefix());
		
		AdStudyMode toMode = student.getStudyMode();
		toMode.setPrefix("P");

		profileService.switchStudyMode(student, academicSession, fromMode, toMode);
		
		
		return self();
		
	}

}
