package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenMyAddressUpdated extends Stage<ThenMyAddressUpdated> {

    @Autowired
    private ProfileService profileService;

    @ExpectedScenarioState
    AdStudent student;

    public ThenMyAddressUpdated my_address_on_file_is_current() {
        List<AdAddress> addresses = profileService.findAddresses(student);
        Assert.notEmpty(addresses);
        return self();
    }
}
