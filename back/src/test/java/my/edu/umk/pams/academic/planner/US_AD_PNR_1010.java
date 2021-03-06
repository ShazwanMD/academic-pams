package my.edu.umk.pams.academic.planner;

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
import my.edu.umk.pams.academic.planner.stage.ThenCurriculumHasAdded;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCurriculum;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;



@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to set up curriculum for a faculty so that curriculum has introduced")
public class US_AD_PNR_1010 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddCurriculum, ThenCurriculumHasAdded>{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1010.class);
	private static final String FACULTY_CODE = "A10";

	@Test
	@Rollback
	public void scenario1006() {
		given().I_am_a_CPS_administrator()
			.and().I_pick_faculty_$(FACULTY_CODE);
		when().Admin_add_curriculum().and().I_review_set_curriculum();
		then().Curriculum_has_added().and().Curriculum_has_reviewed();
	}
}
