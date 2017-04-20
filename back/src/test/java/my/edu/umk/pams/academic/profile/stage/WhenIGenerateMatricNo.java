package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.common.service.CommonService;
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
	@Autowired
	private CommonService commonService;
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
	private AdStudyMode fromMode;
	
	
	public WhenIGenerateMatricNo student_transfer_faculty() {
		//student
		LOG.debug("");
		student = identityService.findStudentByMatricNo("A17M0009F");
		LOG.debug("Student Old MatricNo:{}", student.getMatricNo());
		LOG.debug("Student Old Faculty Name :{}", student.getCohort().getProgram().getFaculty().getName());
		LOG.debug("Student Old Faculty Prefix :{}", student.getCohort().getProgram().getFaculty().getPrefix());
		LOG.debug("");
		//Faculty Old
		fromFaculty = student.getCohort().getProgram().getFaculty();
		fromFaculty.getPrefix();
		//Faculty New
		AdFaculty toFaculty = plannerService.findFacultyByCode("A11");
		toFaculty.getName();
		toFaculty.getPrefix();
		LOG.debug("Student New Faculty :{}", toFaculty.getName());
		LOG.debug("Student New Faculty Prefix :{}", toFaculty.getPrefix());
		//Set Faculty
		student.getCohort().getProgram().setFaculty(toFaculty);
		
		profileService.transferFaculty(student, academicSession, fromFaculty, toFaculty);
		
		return self();
		
	}
	
	public WhenIGenerateMatricNo student_switch_studyMode(){
		//student
		student = identityService.findStudentByMatricNo("H17M0001F");
		LOG.debug("Student Old MatricNo:{}", student.getMatricNo());
		//From StudyMode		
		fromMode = student.getStudyMode();
		fromMode.getPrefix();
		LOG.debug("Student Old StudyMode Prefix :{}", fromMode.getPrefix());
		LOG.debug("Student Old StudyMode Desc :{}", fromMode.getDescription());
		LOG.debug("");
		//New StudyMode
		AdStudyMode toMode = commonService.findStudyModeByCode("2");
		toMode.getDescription();
		toMode.getPrefix();
		LOG.debug("Student New StudyMode Prefix :{}", toMode.getPrefix());
		
		//set StudyMode
		student.setStudyMode(toMode);
		LOG.debug("Student New StudyMode Desc :{}",student.getStudyMode().getDescription());
		
		profileService.switchStudyMode(student, academicSession, fromMode, toMode);
		
		return self();
	}

}
