package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.AcademicConstants;
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
	private AdAcademicSession session;
	
	@ProvidedScenarioState
	private AdFaculty fromFaculty;
	
	@ProvidedScenarioState
	private AdAcademicYear year;
	
	@ProvidedScenarioState
	private AdProgram program;
	
	
	public WhenIGenerateMatricNo i_generate_new_matricNo() {
		
/*		student = identityService.findStudentByMatricNo("A17P009");
		LOG.debug("Student Name :{}", student.getName());
		//Old Faculty
		AdFaculty fromFaculty = student.getCohort().getProgram().getFaculty();
		fromFaculty.getPrefix();		
		LOG.debug("Faculty OLD :{}",fromFaculty.getName());
		LOG.debug("Prefix :{}",fromFaculty.getPrefix());
		//New Faculty
		AdFaculty toFaculty = student.getCohort().getProgram().getFaculty();
		toFaculty.setPrefix("C");*/
	
//		session = plannerService.findAcademicSessionByCode("201720181");
		student = identityService.findStudentByMatricNo("F17P0001P");
		LOG.debug("studymode test kat when : {}", student.getStudyMode());
//		session = cohort.getSession();
		LOG.debug("session test {}", student.getCohort().getId());
//		year = session.getYear();
		cohort = student.getCohort();
		LOG.debug("session test {}", cohort.getSession());
		program  = cohort.getProgram();
		AdFaculty fromFaculty = student.getCohort().getProgram().getFaculty();
		AdFaculty newFac = plannerService.findFacultyByCode("A11");
		AdFaculty toFaculty = newFac;
		//toFaculty.setPrefix("C");
		AdAcademicSession session = student.getCohort().getSession();
		//session.setYear(year);
		
		
		profileService.transferFaculty(student, session, fromFaculty, toFaculty);
		
		
		
		return self();
		
	}

}
