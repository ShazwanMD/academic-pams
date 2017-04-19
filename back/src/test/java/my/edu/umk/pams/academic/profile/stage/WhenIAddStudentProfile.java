package my.edu.umk.pams.academic.profile.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@JGivenStage
public class WhenIAddStudentProfile extends Stage<WhenIAddStudentProfile> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddStudentProfile.class);

    @Autowired
    private IdentityService identityService;

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
    
    public WhenIAddStudentProfile mgseb_add_student_profile() {
    	
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
        
        level = program.getProgramLevel();
        LOG.debug("Level of Study :{}", level.getCode());
        LOG.debug("");
        
        faculty = program.getFaculty();
        LOG.debug("Faculty :{}", faculty.getName());
        LOG.debug("");
  	
        return self();
    }
    
    
    public WhenIAddStudentProfile cps_add_student_profile() {
    	
    	student = identityService.findStudentByMatricNo(matricNo);
    	studentStatus = student.getStudentStatus();
     	LOG.debug("CPS STUDENT ==========================================");
        LOG.debug("Student's Name:{}", student.getName());
        LOG.debug("Student's IdentityNo :{}", student.getMatricNo());
        LOG.debug("Student's StudentStatus :{}", student.getStudentStatus());
        LOG.debug("Student's Emails :{}", student.getEmail());
        LOG.debug("Student's MobileNo :{}", student.getMobile());
        LOG.debug("Student's PhoneNo :{}", student.getPhone());
        
        cohort = student.getCohort();
        LOG.debug("Cohort :{}", cohort.getCode());
        LOG.debug("");
        
        program = cohort.getProgram();
        LOG.debug("Program :{}", program.getCode());
        LOG.debug("");
        
        level = program.getProgramLevel();
        LOG.debug("Level of Study :{}", level.getCode());
        LOG.debug("");
        
        faculty = program.getFaculty();
        LOG.debug("Faculty :{}", faculty.getName());
        LOG.debug("");
  	
        return self();
    }

}
