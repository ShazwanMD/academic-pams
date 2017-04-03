package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */


@JGivenStage
public class WhenIUpdateMailingAddress extends Stage<WhenIUpdateMailingAddress> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateMailingAddress.class);

    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private IdentityService identityService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private AdStudent student;
    
    @ExpectedScenarioState
    private AdAddress address;

    public WhenIUpdateMailingAddress I_update_mailing_address() {

    	student = identityService.findStudentByStudentNo("A17P001");
    	
    	address = profileService.findAddress(student);
    	
    	address.setAddress1("LOT 431");
    	address.setAddress2("Jalan SK Bunut Payong");
    	address.setAddress3("Jalan Kuala Krai");
    	address.setPostCode("15150");
    	address.setType(AdAddressType.MAILING);
    	address.setCountryCode(commonService.findCountryCodeByCode("MY"));
    	address.setStateCode(commonService.findStateCodeByCode("MY-01"));
    	
    	profileService.updateAddress(student, address);
    	
    	
        return self();
    }

}
