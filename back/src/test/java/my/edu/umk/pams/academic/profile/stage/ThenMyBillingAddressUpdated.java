package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenMyBillingAddressUpdated extends Stage<ThenMyBillingAddressUpdated> {

	@Autowired
	private ProfileService profileService;
	
	@ExpectedScenarioState
	AdStudent student;
	
	public ThenMyBillingAddressUpdated my_billing_address_on_file_is_current() {
        List<AdAddress> addresses = profileService.findAddresses(student);
        Assert.notEmpty(addresses);
        return self();
    }
	
}
