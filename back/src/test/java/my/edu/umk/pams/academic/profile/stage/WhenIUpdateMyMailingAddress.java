package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.dao.AdStudentDao;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIUpdateMyMailingAddress extends Stage<WhenIUpdateMyMailingAddress> {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private AdStudentDao studentDao;

    @ExpectedScenarioState
    AdStudent student;

    public WhenIUpdateMyMailingAddress I_update_my_home_address() {
        AdAddress address = new AdAddressImpl();
        address.setType(AdAddressType.MAILING);
        address.setAddress1("Jalan Petaling");
        address.setAddress2("Petaling Jaya");
        address.setCountryCode(commonService.findCountryCodeByCode("Johor"));
        profileService.updateAddress(student, address);

        return self();
    }

}
