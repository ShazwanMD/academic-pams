package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheNewAdmissionIsAdded;
import my.edu.umk.pams.academic.term.stage.WhenIApproveNewAdmissionForStudent;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
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
@As("As a academic administrator, I want to approve new admission for student so that the new admission is added")
public class US_AD_TRM_1025
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIApproveNewAdmissionForStudent, ThenTheNewAdmissionIsAdded>  {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1025.class);
	public static final String PROGRAM_CODE = "A01/PHD/0001";

	@Test
	@Rollback(true)
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_program_$(PROGRAM_CODE);
		when().I_approve_new_admission_for_student();
		then().the_new_admission_is_added();
	}
}