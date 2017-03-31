package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIAccessStudentStatus extends Stage<WhenIAccessStudentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAccessStudentStatus.class);

    @Autowired
    private IdentityService identityService;

    @ExpectedScenarioState
    private AdStudent student;

    public WhenIAccessStudentStatus i_access_student_status(String identityNo) {
        student = identityService.findStudentByStudentNo(identityNo);
        Assert.notNull(student, "Student cannot be null");

        return self();
    }

}