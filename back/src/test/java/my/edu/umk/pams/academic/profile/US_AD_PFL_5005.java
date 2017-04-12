package my.edu.umk.pams.academic.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenLecturerReviewedStudentBarredStatus;
import my.edu.umk.pams.academic.profile.stage.WhenLecturerReviewStudentBarredStatus;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor, I can view the barring status of students so that I can know the discipline issues status under my supervision")
@Submodule("Profile")
@Issue("PAMA-67")
public class US_AD_PFL_5005 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenLecturerReviewStudentBarredStatus, ThenLecturerReviewedStudentBarredStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_5005.class);
	private static final String IDENTITY_NO = "A17P001";
	  
	@Test
	@Rollback
	public void scenario5005(){
		given().i_am_a_staff_in_current_academic_session();
		when().Lecturer_review_student_$_barred_status(IDENTITY_NO);
		then().Lecturer_reviewed_student_barred_status();
	}
}
