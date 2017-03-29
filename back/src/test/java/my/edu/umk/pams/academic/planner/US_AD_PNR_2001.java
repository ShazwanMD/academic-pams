package my.edu.umk.pams.academic.planner;

/**
 * As an a student,
 *  i want to view level of study 
 *  	so that I know my level of studies
 *
 * @author zaida_ain
 */

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramLevelReviewed;
import my.edu.umk.pams.academic.planner.stage.WhenIReviewProgramLevel;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
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

public class US_AD_PNR_2001 extends SpringScenarioTest<GivenIAmStudent, WhenIReviewProgramLevel, ThenProgramLevelReviewed> {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_2001.class);

    private String FACULTY_CODE = "10";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "PGRAM_231";

    @Test
    @Rollback
    public void scenari2001() {
        given().I_am_a_student_in_current_academic_session();
        when().I_review_program_level_$(FACULTY_CODE);
        then().Program_level_introduced();
    }
}

	


