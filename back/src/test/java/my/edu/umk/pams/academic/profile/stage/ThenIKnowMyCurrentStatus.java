package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenIKnowMyCurrentStatus extends Stage<ThenIKnowMyCurrentStatus> {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private IdentityService identityService;


    @ExpectedScenarioState
    private AdStudent student;

    @Pending
    public ThenIKnowMyCurrentStatus I_know_my_current_status() {
        //List<AdStatus> statuses = profileService.findStatus(student);
        //Assert.notEmpty(statuses);
        return self();
    }

}
