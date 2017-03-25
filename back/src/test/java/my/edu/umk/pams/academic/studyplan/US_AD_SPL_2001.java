package my.edu.umk.pams.academic.studyplan;

/**
 * As an admin academic,
 * I am a student in current academic session,
 * so that Can take in new semester.
 *
 * @author zaida
 */

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenCanTakeInNewSemester;
import my.edu.umk.pams.academic.studyplan.stage.WhenIWantToViewTheProgramForEachLevelOfStudy;
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

public class US_AD_SPL_2001 extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewTheProgramForEachLevelOfStudy, ThenCanTakeInNewSemester> {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_2001.class);

    private String FACULTY_CODE = "10";

    @ProvidedScenarioState
    private String PROGRAM_CODE = "PGRAM_231";

    @Test
    @Rollback(true)
    public void scenari2001() {
        given().I_am_a_student_in_current_academic_session();
        when().I_want_to_view_the_program_$_for_each_level_of_study(FACULTY_CODE);
        then().Can_take_in_new_semester();
    }
}

	


