package my.edu.umk.pams.academic.profile.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@JGivenStage
public class WhenIAddStudentProfile extends Stage<WhenIAddStudentProfile> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddStudentProfile.class);

    @Autowired
    private IdentityService identityService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdActor actor;

    public WhenIAddStudentProfile I_add_student_profile() {

        AdStudent student = new AdStudentImpl();
        student.setName("sam");
        student.setPhone("0179282817");
        student.setIdentityNo("01607r");
        student.setFax("079449205");
        student.setEmail("shazwan.md@umk.edu.my");
        student.setMobile("0123");
        student.setMatricNo("1111" + System.currentTimeMillis()); // append some random number
        student.setStudentStatus(AdStudentStatus.ACTIVE);
        identityService.saveStudent(student);

        return self();
    }

}
