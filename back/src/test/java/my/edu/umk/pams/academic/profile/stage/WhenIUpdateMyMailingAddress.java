package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */


@JGivenStage
public class WhenIUpdateMyMailingAddress extends Stage<WhenIUpdateMyMailingAddress> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateMyMailingAddress.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private AdStudent student;

    public WhenIUpdateMyMailingAddress I_update_my_mailing_address() {
        AdAddress address = new AdAddressImpl();
        address.setType(AdAddressType.MAILING);
        address.setAddress1("Jalan Petaling");
        address.setAddress2("Petaling Jaya");
        address.setStateCode(commonService.findStateCodeByCode("MY-01"));
        address.setCountryCode(commonService.findCountryCodeByCode("MY"));
        profileService.addAddress(student, address);

        return self();
    }

}
