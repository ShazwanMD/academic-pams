package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIUpdateMailingAddress extends Stage<WhenIUpdateMailingAddress> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateMailingAddress.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private AdStudent student;
    
    @ProvidedScenarioState
    private List<AdCountryCode> countryCodes;

    public WhenIUpdateMailingAddress I_update_mailing_address() {
        Assert.notNull(student, "student cannot be null");
        List<AdAddress> addresses = student.getAddresses();
        Assert.notEmpty(addresses, "addresses cannot be empty");
        LOG.debug("Addresses found: {}", addresses.size());

        for (AdAddress address : addresses) {
            address.setAddress1("LOT 431");
            address.setAddress2("Jalan SK Bunut Payong");
            address.setAddress3("Jalan Kuala Krai");
            address.setPostCode("15150");
            address.setType(AdAddressType.MAILING);
            address.setStateCode(commonService.findStateCodeByCode("MY-03"));
            address.setCountryCode(commonService.findCountryCodeByCode("MY"));

            profileService.updateAddress(student, address);
        }
        return self();
    }

    public WhenIUpdateMailingAddress I_review_mailing_address() {
        List<AdAddress> addresses = student.getAddresses();
        Assert.notEmpty(addresses, "addresses cannot be empty");
        for (AdAddress address : addresses)
            LOG.debug("Find Address by Student Matric No :{}", address.getAddress1() + "," +
                    address.getAddress2() + "," +
                    address.getAddress3() + "," +
                    address.getPostCode() + "," +
                    address.getStateCode().getDescription() + "," +
                    address.getCountryCode().getDescription());

        return self();
    }
    
    public WhenIUpdateMailingAddress test_countryCode(){
    	
    	countryCodes = commonService.findCountryCodes("", 0, 10);
    	Assert.notEmpty(countryCodes);
    	
    	for(AdCountryCode countryCode:countryCodes)
    		LOG.debug("CountryCode:{}", countryCode.getCode());
    	return self();
    }
}
