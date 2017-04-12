package my.edu.umk.pams.academic.assessment;

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

import my.edu.umk.pams.academic.assessment.stage.ThenGradesIsUpdated;
import my.edu.umk.pams.academic.assessment.stage.WhenInsertGrades;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an admin faculty/admin postgraduate, I want to insert grading, so that I can update grades.")

public class US_AD_ASMT_3006 extends SpringScenarioTest <GivenIAmAdministrator, WhenInsertGrades, ThenGradesIsUpdated> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_3006.class);
	
private String ACADEMIC_SESSION = "201720181";
	
	@Test
	@Rollback
	public void scenario3006_cps(){
		
	String USERNAME = "cps";
	String PASSWORD = "abc123";
		
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
			when().insert_student_grades();
				then().student_grades_updated();
	}
	
	@Test
	@Rollback
	public void scenario3006_mgseb(){
					
	String USERNAME = "mgseb";
	String PASSWORD = "abc123";
					
		given().i_am_a_$_administrator_in_$_academic_session(ACADEMIC_SESSION, USERNAME, PASSWORD);
			when().insert_student_grades();
				then().student_grades_updated();		


	}

}
