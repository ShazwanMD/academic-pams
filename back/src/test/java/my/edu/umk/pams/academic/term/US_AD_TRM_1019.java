package my.edu.umk.pams.academic.term;

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
import my.edu.umk.pams.academic.term.stage.ThenTheAdvisorInfoIsCurrent;
import my.edu.umk.pams.academic.term.stage.WhenIViewAppointedAdvisorInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view appointed advisor info so that the advisor info is current")

public class US_AD_TRM_1019 extends SpringScenarioTest<GivenIAmStudent, WhenIViewAppointedAdvisorInfo, ThenTheAdvisorInfoIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_TRM_1019.class);

	@Test
	@Rollback(true)
	public void scenario01() {
		given().I_am_a_student_in_current_academic_session();
		when().I_want_to_view_appointed_advisor_info();
		then().The_advisor_info_is_current();
	}
}
