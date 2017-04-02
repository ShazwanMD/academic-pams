package my.edu.umk.pams.academic.planner;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.stage.ThenCourseInformationReviewed;
import my.edu.umk.pams.academic.planner.stage.WhenIViewCourseInfomation;
import my.edu.umk.pams.academic.profile.stage.WhenIViewCourseInfo;
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
 * I Am Student
 * I Review Course Info
 * Course Information Reviewed
 * @author zaida
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PNR_2003
		extends SpringScenarioTest<GivenIAmStudent, WhenIViewCourseInfomation, ThenCourseInformationReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PNR_2003.class);

	private static final String FACULTY_CODE = "FKP";

	@Test
	@Rollback
	public void scenario2003() {
		given().I_am_a_student_in_current_academic_session();
		when().I_view_course_infomation_$(FACULTY_CODE);
		then().course_information_reviewed();
	}
}

