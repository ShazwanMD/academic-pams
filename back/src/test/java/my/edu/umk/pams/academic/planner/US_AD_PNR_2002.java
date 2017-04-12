package my.edu.umk.pams.academic.planner;
/**
 * @author zaida
 */
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenProgramInfomationReviewed;
import my.edu.umk.pams.academic.planner.stage.WhenIReviewProgramInfomation;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student, i want to view program by faculty so that i can manage schedule detail")
@Issue("PAMA-16")
@Submodule("Planner")
public class US_AD_PNR_2002
        extends SpringScenarioTest<GivenIAmStudent, WhenIReviewProgramInfomation, ThenProgramInfomationReviewed> {

    private static final String FACULTY_CODE = "A01";

    @Test
    @Rollback
    public void ReviewProgramInfomation() {
        given().I_am_a_student_in_current_academic_session();
        when().I_Review_program_by_faculty_$(FACULTY_CODE);
        then().Program_Infomation_reviewed();
    }
}