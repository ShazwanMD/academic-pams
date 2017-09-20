package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
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
    private List<AdAddress> addresses;
 
    @ExpectedScenarioState
    private AdAddress address;
    
    @ProvidedScenarioState
    private AdCountryCode countryCode;

    private String code;
    
    public WhenReviewStudentProfileInfo supervisor_review_student_profile(String studentNo) {
        
    	student = identityService.findStudentByMatricNo(studentNo);
        addresses = profileService.findAddresses(student);
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
          
    }

        return self();
    }
}
