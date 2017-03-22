package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenCurrentStudentProfileUpdate extends Stage<ThenCurrentStudentProfileUpdate> {


    @Autowired
    private IdentityService identityService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdStaff staff;

    @ExpectedScenarioState
    private AdActor actor;

    public ThenCurrentStudentProfileUpdate Current_student_profile_is_updated() {

        Assert.isNull(actor, "shazwan");


        return self();

    }

}
