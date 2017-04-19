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
import my.edu.umk.pams.academic.term.stage.ThenSectionsCurrentAppointedStaff;
import my.edu.umk.pams.academic.term.stage.WhenIUpdateAppointStaffIntoSection;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Submodule;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a academic administrator, I want to update appoint staff for the particular sections, so that the sections have current appointed staff info.")
@Submodule("Term")
public class US_AD_TRM_1027  extends
SpringScenarioTest<GivenIAmCPSAdministrator, WhenIUpdateAppointStaffIntoSection, ThenSectionsCurrentAppointedStaff> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1027 .class);
	//private static final String STAFF_NO = "01001A"; // from data/AD_ACTR.sql
	private static final String SECTION_CANONICAL_CODE = "FIAT/MASTER/PBH/GST5023/201720181";
	
	@Test
	@Rollback(true)
	public void scenario1() {
		given().I_am_a_CPS_administrator_in_current_academic_session().and().I_pick_section_$(SECTION_CANONICAL_CODE);
		when().I_update_appoint_staff_into_section();
		then().Section_current_appointed_staff_info();
	}

}
