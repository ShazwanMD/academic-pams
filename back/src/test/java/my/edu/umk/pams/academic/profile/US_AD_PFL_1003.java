package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenActivationStatusReviewed;
import my.edu.umk.pams.academic.profile.stage.WhenIReviewActivationStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, I want to view student activation status so that I know my current status")
public class US_AD_PFL_1003 extends SpringScenarioTest<GivenIAmStudent, WhenIReviewActivationStatus, ThenActivationStatusReviewed> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1003.class);
    private static final String IDENTITY_NO = "A17P001";

    @Test
    @Rollback
    public void scenario1003() {
        given().I_am_a_student_in_current_academic_session();
        when().I_review_activation_status_$(IDENTITY_NO);
        then().activation_status_reviewed();
    }

}
