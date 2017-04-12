package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.term.stage.ThenTheEnrollmentIsUpdated;
import my.edu.umk.pams.academic.term.stage.ThenTheSectionHasAverageQuota;
import my.edu.umk.pams.academic.term.stage.WhenITransferSection;
import my.edu.umk.pams.academic.term.stage.WhenIWantToSplitSection;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to split section, so that the section has average quota.")
@Submodule("Term")
public class US_AD_TRM_1007 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIWantToSplitSection, ThenTheSectionHasAverageQuota> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1007.class);
 
@Test
@Rollback(true)
public void scenario1() {
	given().I_am_a_CPS_administrator_in_current_academic_session();
	when().I_want_to_split_section();
	then().the_section_has_average_quota();
	
  }

}


