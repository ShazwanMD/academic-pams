package my.edu.umk.pams.academic.assessment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.academic.assessment.stage.ThenICanViewStudentSubjectRegistered;
import my.edu.umk.pams.academic.assessment.stage.WhenIViewStudentInfo;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor, I want to view student info, so that I can view student's subject registered")
public class US_AD_ASMT_2000 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenIViewStudentInfo, ThenICanViewStudentSubjectRegistered>  {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2000.class);
	
	public static String IDENTITY_NO = "A17P002";
	
	@Test
    @Rollback
    public void scenario2000() {
		given().i_am_a_staff_in_current_academic_session();
		when().i_view_student_info(IDENTITY_NO);
		then().i_can_view_student_subject_registered(IDENTITY_NO);
		
	
	}
	
}

