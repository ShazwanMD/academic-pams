package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCoursePrerequisiteAdded;
import my.edu.umk.pams.academic.planner.stage.WhenAdminAddCoursePrerequisite;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 * @author ain
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_PNR_1007 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminAddCoursePrerequisite, ThenCoursePrerequisiteAdded> {

private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1007.class);

	private static final String COURSE_CODE = "DDA2103";
	private static final String PREREQ_CODE = "DDA2113";

    @Test
    @Rollback
    public void scenario1007() {
        given().I_am_a_CPS_administrator_in_current_academic_session();
        when().Admin_add_prereq_$_to_course_$(PREREQ_CODE, COURSE_CODE);
        then().course_$_is_a_prereq_for_course_$(PREREQ_CODE, COURSE_CODE);
    }

}
