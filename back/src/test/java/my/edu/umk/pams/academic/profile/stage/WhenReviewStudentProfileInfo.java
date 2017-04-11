package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenReviewStudentProfileInfo extends Stage<WhenReviewStudentProfileInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentProfileInfo.class);

    @Autowired
    private IdentityService identityService;
   
    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private AdStudent student;
    
    @ExpectedScenarioState
    private AdStudentStatus studentStatus;

    @ExpectedScenarioState
    private List<AdAddress> addresses;
 
    @ExpectedScenarioState
    private AdAddress address;
    
    @ExpectedScenarioState
    private AdCohort cohort;
    
    @ExpectedScenarioState
    private AdProgram program;
    
    @ExpectedScenarioState
    private AdProgramLevel level;
    
    @ProvidedScenarioState
    private AdCountryCode countryCode;
    
    @ExpectedScenarioState
    private AdFaculty faculty;
    
    @ExpectedScenarioState
    private AdCourse course;

    private String code;
    
    public WhenReviewStudentProfileInfo supervisor_review_student_profile(String studentNo) {
        //Student
    	student = identityService.findStudentByMatricNo(studentNo);
    	LOG.debug("Student's Name:{}", student.getName());
    	
    	//addresss
    	addresses = student.getAddresses();
        countryCode = commonService.findCountryCodeByCode(code);
        for (AdAddress address : addresses) {
        	LOG.debug("Student's name : {}", student.getName());
            LOG.debug("Student's matric number : {}", student.getMatricNo());
            LOG.debug("Student's email : {}", student.getEmail());
            LOG.debug("Student's mobile number : {}", student.getMobile());
            LOG.debug("Student's phone number : {}", student.getPhone());
            LOG.debug("Student's status	: {}", student.getStudentStatus());
        	
            LOG.debug("Student's address: {}", address.getAddress1());
            LOG.debug("Student's address: {}", address.getAddress2());
            LOG.debug("Student's address: {}", address.getAddress3());
            LOG.debug("Student's postcode: {}", address.getPostCode());
           
            countryCode = address.getCountryCode();
            LOG.debug("Country Code:{}", countryCode.getCode());
            LOG.debug("Country Code:{}", countryCode.getDescription());
    }
      
        //Student Status
        studentStatus = student.getStudentStatus();
        LOG.debug("StudentStatus:{}", studentStatus.name());
        
        //cohort
        cohort = student.getCohort();
        LOG.debug("Cohort:{}", cohort.getCode());
        
        
        //program
        program = cohort.getProgram();
        LOG.debug("Program(s):{}", program.getCode());
        
        level = program.getProgramLevel();
        LOG.debug("Program Level:{}", level.getCode());
        
        faculty = program.getFaculty();
        LOG.debug("Faculty:{}", faculty.getName());
        
        List<AdCourse> courses = faculty.getCourses();
        for(AdCourse course:courses)
        	LOG.debug("Course(s):{}", course.getCode());
        
        
        
   
        return self();
    }
}
