package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenIKnowMyCurrentStatus;
import my.edu.umk.pams.academic.profile.stage.ThenIKnowStudentCurrentStatus;
import my.edu.umk.pams.academic.profile.stage.WhenIViewMyStudentStatus;
import my.edu.umk.pams.academic.profile.stage.WhenIViewStudentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*As a bursary,
I want to view student activation status,
so that I know the students current status	
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)


public class US_AD_PFL_3002 extends SpringScenarioTest<GivenIAmBursary, WhenIViewStudentStatus, ThenIKnowStudentCurrentStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_3002.class);

    @Test
    @Rollback
    public void scenario3002() {
        given().I_am_a_bursary_in_current_academic_session();
        when().I_view_student_status();
        then().I_know_student_current_status();
    }

}






