package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.Pending;
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
import my.edu.umk.pams.academic.planner.stage.ThenCurriculumHasAdded;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCurriculum;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to set up curriculum for a faculty so that curriculum has introduced")
public class US_AD_PNR_1006 extends
		SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddCurriculum, ThenCurriculumHasAdded>{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1006.class);
	private static final String FACULTY_CODE = "A10";

	@Test
	@Rollback
	public void addCurriculum() {
		given().I_am_a_CPS_administrator()
			.and().I_pick_faculty_$(FACULTY_CODE);
		when().add_curriculum();
		then().curriculum_is_added()
		.and().print_to_console();
	}

	@Test
	@Rollback
	@Pending
	public void removeCurriculum() {
	}

	@Test
	@Rollback
	@Pending
	public void updateCurriculum() {
	}
}
