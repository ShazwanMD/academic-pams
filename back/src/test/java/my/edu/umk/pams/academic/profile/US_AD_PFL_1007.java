package my.edu.umk.pams.academic.profile;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.profile.stage.ThenProgramInfoIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIViewProgramInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As a student,
 * I want to view programme info,
 * so that I can view my registered programme
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_1007 extends SpringScenarioTest<GivenIAmStudent, WhenIViewProgramInfo, ThenProgramInfoIsCurrent> {

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1007.class);

    private static final String FACULTY_CODE = "FKP";

    @Test
    @Rollback
    public void scenario1007() {
        given().I_am_a_student_in_current_academic_session();
        when().I_view_program_info_for_faculty_$(FACULTY_CODE);
        then().Program_info_is_current();
    }
}
