package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramLevelReviewed;
import my.edu.umk.pams.academic.planner.stage.WhenIReviewProgramLevel;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

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
@As("As a student, i want to view level of study so that I know my level of studies")
@Issue("PAMA-15")
@Submodule("Planner")
public class US_AD_PNR_2001 extends SpringScenarioTest<GivenIAmStudent, WhenIReviewProgramLevel, ThenProgramLevelReviewed> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_2001.class);
    private static final String CODE = "DIPLOMA";

    @Test
    @Rollback
    public void ReviewProgramLevel() {
        given().I_am_a_student_in_current_academic_session();
        when().I_review_program_level_$(CODE);
        then().Program_level_introduced();
    }
}

	


