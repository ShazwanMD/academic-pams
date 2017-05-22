package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.profile.service.ProfileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIUpdateStudentProfileInfo extends Stage<WhenIUpdateStudentProfileInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateStudentProfileInfo.class);


    @Autowired
    private IdentityService identityService;
    
    @Autowired
    private ProfileService profileService;

    @ExpectedScenarioState
    private AdStudent student;
    
    @ProvidedScenarioState
    private AdStudentStatus studentStatus;
    
    @ProvidedScenarioState
    private AdCohort cohort;

    @ProvidedScenarioState
    private AdProgram program;
    
    @ProvidedScenarioState
    private AdProgramLevel level;
    
    @ProvidedScenarioState
    private AdFaculty faculty;
    
    @ExpectedScenarioState
    private AdActor actor;
    
    @ExpectedScenarioState
    private static String matricNo;

    public WhenIUpdateStudentProfileInfo CPS_update_student_profile_info() {

     	student = identityService.findStudentByMatricNo(matricNo);
    	studentStatus = student.getStudentStatus();
    	LOG.debug("MGSEB STUDENT ==========================================");
        LOG.debug("Student's Name:{}", student.getName());
        LOG.debug("Student's IdentityNo :{}", student.getMatricNo());
        LOG.debug("Student's StudentStatus :{}", student.getStudentStatus());
        LOG.debug("Student's Emails :{}", student.getEmail());
        LOG.debug("Student's MobileNo :{}", student.getMobile());
        LOG.debug("Student's PhoneNo :{}", student.getPhone());
        LOG.debug("");
        
        cohort = student.getCohort();
        LOG.debug("Cohort :{}", cohort.getCode());
        LOG.debug("");
        
        program = cohort.getProgram();
        LOG.debug("Program :{}", program.getCode());
        LOG.debug("");
        
        level = program.getLevel();
        LOG.debug("Level of Study :{}", level.getCode());
        LOG.debug("");
        
        faculty = program.getFaculty();
        LOG.debug("Faculty :{}", faculty.getName());
        LOG.debug("");
    	

        student = identityService.findStudentByMatricNo(matricNo);
        student.setIdentityNo("F17P0001F");
        identityService.updateStudent(student);
        LOG.debug("New Student Matric No :{}", student.getMatricNo());
        LOG.debug("");
        
        return self();
    }
    
    public WhenIUpdateStudentProfileInfo CPS_update_status() {
    	

     	student = identityService.findStudentByMatricNo("F17P0001F");
    	studentStatus = student.getStudentStatus();
    	LOG.debug("MGSEB STUDENT ==========================================");
        LOG.debug("Student's Name:{}", student.getName());
        LOG.debug("Student's IdentityNo :{}", student.getMatricNo());
        LOG.debug("Student's StudentStatus :{}", student.getStudentStatus());
        
        AdFaculty fromFaculty = student.getCohort().getProgram().getFaculty();
        
        AdFaculty toFaculty = student.getCohort().getProgram().getFaculty();
        
		//Activate student status from old status
        student.setStudentStatus(AdStudentStatus.ACTIVE);
        profileService.activateStudent(student);
        LOG.debug("StudentNewStatus:{}",student.getStudentStatus());
    	
    	return self();
    }
    
    

}
