package my.edu.umk.pams.academic.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenStudentStatusViewed;
import my.edu.umk.pams.academic.profile.stage.WhenReviewStudentStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

/*As a lecturer,
I want to view student activation status 
So that I can know my student’s current status under my lectures.
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_4002 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenReviewStudentStatus, ThenStudentStatusViewed>
{
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_4002.class);
	
	private static final String IDENTITY_NO = "A17P001";
		
    @Test
    @Rollback
    public void scenario4002(){
	given().I_am_a_staff_in_current_academic_session();
    when().I_view_student_current_status_for_$(IDENTITY_NO);
    then().I_know_student_status_current();

    }
}