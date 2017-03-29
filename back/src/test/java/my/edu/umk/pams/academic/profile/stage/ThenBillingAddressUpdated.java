package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenBillingAddressUpdated extends Stage<ThenBillingAddressUpdated> {

    @Autowired
    private ProfileService profileService;

    @ExpectedScenarioState
    AdStudent student;

    public ThenBillingAddressUpdated Billing_address_updated() {
        List<AdAddress> addresses = profileService.findAddresses(student);
        Assert.notEmpty(addresses, "addresses cannot be empty");
        return self();
    }

}
