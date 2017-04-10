package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramDetailReviewed;
import my.edu.umk.pams.academic.planner.stage.WhenAdminReviewProgram;
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
@As("As an academic administrator, I want to view program for a faculty so that i know program detail")
public class US_AD_PNR_1004 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenAdminReviewProgram, ThenProgramDetailReviewed> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_1004.class);
    
    private static final String FACULTY_CODE = "A07";

    @Test
    @Rollback
    public void scenario0004() {
        given().I_am_a_CPS_administrator_in_current_academic_session();
        when().Admin_review_program_for_that_faculty_$(FACULTY_CODE);
        then().Program_details_reviewed();
    }
}
