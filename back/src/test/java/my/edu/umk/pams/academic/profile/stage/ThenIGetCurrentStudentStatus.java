package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

@JGivenStage
public class ThenIGetCurrentStudentStatus extends Stage<ThenIGetCurrentStudentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenIGetCurrentStudentStatus.class);

    @ExpectedScenarioState
    private AdStudent student;

    public ThenIGetCurrentStudentStatus i_get_the_students_current_status() {

        AdStudentStatus expectedStatus = AdStudentStatus.ACTIVE;
        String message = "Status should be AdStudentStatus.ACTIVE";

        AdStudentStatus actualStatus = student.getStudentStatus();


        Assert.isTrue(expectedStatus.equals(actualStatus), message);

        return self();
    }

}
