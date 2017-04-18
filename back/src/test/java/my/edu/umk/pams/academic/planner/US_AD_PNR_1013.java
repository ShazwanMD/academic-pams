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
import my.edu.umk.pams.academic.planner.stage.ThenCoursePrerequisiteUpdated;
import my.edu.umk.pams.academic.planner.stage.WhenIUpdateCoursePrerequisite;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, i want to update  course prerequisite so that courses prerequisite updated")
@Issue("")
@Submodule("Planner")
public class US_AD_PNR_1013  extends
SpringScenarioTest<GivenIAmCPSAdministrator,WhenIUpdateCoursePrerequisite , ThenCoursePrerequisiteUpdated> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1013.class);
	private static final String COURSE_CODE = "GST5033";
	private static final String PREREQ_CODE = "GST5043";
	
	@Test
	@Rollback
	public void UpdatePrerequisite() {
		given().I_am_a_CPS_administrator_in_current_academic_session();
		when().Admin_update_prereq_$_to_course_$(PREREQ_CODE, COURSE_CODE);
		then().course_$_is_a_prereq_for_course_$_update(PREREQ_CODE, COURSE_CODE);
	
}                                                                                                                                                  
	}
