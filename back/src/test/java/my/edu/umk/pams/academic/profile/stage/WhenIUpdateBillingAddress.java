package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
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

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIUpdateBillingAddress extends Stage<WhenIUpdateBillingAddress> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateBillingAddress.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdStudent student;

    @ProvidedScenarioState
    private AdAddress address;

    public WhenIUpdateBillingAddress I_add_my_billing_address() {
        
    	AdAddress address = new AdAddressImpl();

        address.setType(AdAddressType.BILLING);
        address.setAddress1("Jalan Petaling");
        address.setAddress2("Petaling Jaya");
        address.setStateCode(commonService.findStateCodeByCode("MY-01"));
        address.setCountryCode(commonService.findCountryCodeByCode("MY"));
        profileService.addAddress(student, address);
     
        return self();
    }

    public WhenIUpdateBillingAddress I_update_billing_address() {
        List<AdAddress> addresses = profileService.findAddresses(student);
        for (AdAddress address : addresses) {
            if (address.getType().equals(AdAddressType.BILLING)) {
                address.setAddress1("Jalan Rumah");
                address.setAddress2("Bestari Jaya");
                address.setStateCode(commonService.findStateCodeByCode("MY-01"));
                address.setCountryCode(commonService.findCountryCodeByCode("MY"));
                profileService.updateAddress(student, address);

            }
        }

        return self();
    }

}