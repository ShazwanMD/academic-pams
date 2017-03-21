package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@JGivenStage
public class WhenIUpdateMyContactNumber extends Stage<WhenIUpdateMyContactNumber> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateMyContactNumber.class);

    @Autowired
    private IdentityService identityService;

    @ExpectedScenarioState
    private AdActor actor;

    @ExpectedScenarioState
    private AdStudent student;


    public WhenIUpdateMyContactNumber I_update_my_contact_number() {

        actor = identityService.findActorByIdentityNo("760607145591");

        actor.setActorType(AdActorType.STUDENT);
        actor.setMobile("0129090123");
        actor.setPhone("097420000");
        identityService.updateStudent(student);
        return self();

    }

}
