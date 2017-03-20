package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenProgramInfoIsCurrent;
import my.edu.umk.pams.academic.profile.stage.WhenIWantToViewProgramInfo;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

/**

As a student, 
	I want to view programme info, 
		so that I can view my registered programme 
**/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_AD_PFL_1007 extends SpringScenarioTest<GivenIAmStudent, WhenIWantToViewProgramInfo, ThenProgramInfoIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_1007.class);
	
	private static final String FACULTY_NO = "45";	
	
	
	@Before
	public void before() {
	}

	@After
	public void after() {
	}
	
	@Test
	@Rollback(true)
	public void scenario1007(){
		
		given().I_am_a_student_in_current_academic_session();
		when(). I_view_program_$_info(FACULTY_NO);
		then().Program_info_is_current();
	}
	
	
}
