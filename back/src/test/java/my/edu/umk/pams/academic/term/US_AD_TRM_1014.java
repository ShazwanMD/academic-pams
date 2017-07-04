package my.edu.umk.pams.academic.term;

import com.tngtech.jgiven.annotation.As;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.term.stage.ThenTheNewAdmissionIsAdded;
import my.edu.umk.pams.academic.term.stage.WhenIApproveNewAdmissionForStudent;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As academic administrator, I want to approve new admission application for student, so that the new student admission is added.")
@Submodule("Term")
public class US_AD_TRM_1014 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenIApproveNewAdmissionForStudent, ThenTheNewAdmissionIsAdded> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1014.class);
	public static final String PROGRAM_CODE = "FIAT-PHD-PBT";
	public static final String STUDENT_ID = "A17P001";

	@Test
	@Rollback(true)
	public void adminApproveNewAdmission() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_program_$(PROGRAM_CODE).and().I_pick_student_$(STUDENT_ID);
		when().I_approve_new_admission_for_student();
		then().the_new_admission_is_added();
	}
}