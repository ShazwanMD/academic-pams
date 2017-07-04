package my.edu.umk.pams.academic.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenStudentBarringStatusReviewed;
import my.edu.umk.pams.academic.profile.stage.WhenReviewStudentBarringStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a lecturer, I can view the barring status of students so that I can know the discipline issues and takes further actions for the next registration process")
@Submodule("Profile")
@Issue("PAMA-62")
public class US_AD_PFL_4003
	extends SpringScenarioTest<GivenIAmAcademicStaff, WhenReviewStudentBarringStatus, ThenStudentBarringStatusReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_4003.class);
	private static final String IDENTITY_NO = "A17P002";
	
    @Test
    @Rollback
    public void scenario4003() {
    	given().i_am_a_staff_in_current_academic_session();
    	when().I_view_student_$_barring_status(IDENTITY_NO);
    	then().I_know_student_barring_status();
 

    }
}
