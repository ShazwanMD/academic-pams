package my.edu.umk.pams.academic.term;
//@author: asyikin.mr
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
import my.edu.umk.pams.academic.term.stage.ThenTheAdmissionWillBeReviewed;
import my.edu.umk.pams.academic.term.stage.WhenIRegisterAdmissionInNewSemester;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_TRM_1023 extends
		SpringScenarioTest<GivenIAmStudent, WhenIRegisterAdmissionInNewSemester, ThenTheAdmissionWillBeReviewed> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1023.class);

	@Test
	@Rollback(true)
	public void scenario01() {

		given().I_am_a_student_in_current_academic_session();
		when().I_register_admission_in_new_semester();
		then().The_admission_will_be_reviewed();

	}
}
