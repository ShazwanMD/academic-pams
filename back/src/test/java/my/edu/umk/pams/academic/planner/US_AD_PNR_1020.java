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
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenBundleSubjectPartAdded;
import my.edu.umk.pams.academic.planner.stage.WhenSetupBundleSubjectPart;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to update program for a faculty so that programmes is updated")
@Issue("PAMA-48")
@Submodule("Planner")

public class US_AD_PNR_1020
		extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenSetupBundleSubjectPart, ThenBundleSubjectPartAdded> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1020.class);
	
	private static final String COURSE_CODE="GST5013";
	
	private static final String FACULTY_CODE="A10";
	
	@Test
	@Rollback
	public void UpdateProgram() {
		given().I_am_a_CPS_administrator();
		when().I_setup_bundle_subject_part_for_course_$(COURSE_CODE,FACULTY_CODE);
		then().bundle_subject_part_is_added();
	}
}

