package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */

@JGivenStage
public class ThenCurrentStudentProfileInfoIsUpdated extends Stage<ThenCurrentStudentProfileInfoIsUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenCurrentStudentProfileInfoIsUpdated.class);
    @Autowired
    private ProfileService profileService;

    @Autowired
    private IdentityService identityService;

    @ExpectedScenarioState
    AdStudent student;

    @ExpectedScenarioState
    AdActor actor;

    public ThenCurrentStudentProfileInfoIsUpdated current_student_profile_info_is_updated() {


        Assert.isNull(actor, "check");

        return self();

    }

}
