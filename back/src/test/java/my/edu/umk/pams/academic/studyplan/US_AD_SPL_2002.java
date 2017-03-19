package my.edu.umk.pams.academic.studyplan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.studyplan.stage.ThenCanTakeInNewSemester;
import my.edu.umk.pams.academic.studyplan.stage.ThenICanPlanWhatToManageScheduleDetail;
import my.edu.umk.pams.academic.studyplan.stage.WhenIWantToViewTheCourseForMyProgram;
import my.edu.umk.pams.academic.studyplan.stage.WhenIWantToViewTheProgramForEachLevelOfStudy;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**
 * As a student, 
 *   i want to view the course for my program
 *       so that I can plan what to manage schedule detail.
 *
 * @author zaida
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_AD_SPL_2002 extends
		SpringScenarioTest<GivenIAmStudent, WhenIWantToViewTheCourseForMyProgram, ThenICanPlanWhatToManageScheduleDetail> {
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_SPL_2002.class);

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	@Test
	@Rollback(true)
	public void scenari2002() {
		given().I_am_a_student_in_current_academic_session();
		when().I_Want_To_View_The_Course_For_My_Program_$("45");
		then().I_Can_Plan_WhaI_Can_Plan_What_To_Manage_Schedule_Detailt();
	}

}
