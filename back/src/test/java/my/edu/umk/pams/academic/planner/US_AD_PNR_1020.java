package my.edu.umk.pams.academic.planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenSubjectAdded;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCurriculum;
import my.edu.umk.pams.academic.planner.stage.WhenBundleSubjectAdd;
import my.edu.umk.pams.academic.planner.stage.WhenSetupSubject;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want setup bundle subject, so that bundle subject part added ")
@Issue("PAMA")
@Submodule("Planner")

public class US_AD_PNR_1020
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenSetupSubject, ThenSubjectAdded> {
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1020.class);

	@ProvidedScenarioState
	private static final String FACULTY_CODE = "A10";
	
	@ProvidedScenarioState
	private static final String COURSE_CODE = "GST5013";
	
	@Test
	@Rollback

	public void setup_bundle_subject() {

		given().I_am_a_CPS_administrator().and().I_pick_faculty_$(FACULTY_CODE);
		addStage(WhenAdminAddCurriculum.class).Admin_add_curriculum();
		when().I_setup_subject_$(COURSE_CODE,FACULTY_CODE);
		addStage(WhenBundleSubjectAdd.class).and().add_bundle_subject_$(COURSE_CODE);
		then(). subject_added();
	}
}
