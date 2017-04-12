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

import my.edu.umk.pams.academic.assessment.stage.ThenGradeUpdated;
import my.edu.umk.pams.academic.assessment.stage.WhenIAmInsertGrade;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor,I want to insert grading So that I can insert student’s grades.")
public class US_AD_ASMT_2004 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenIAmInsertGrade, ThenGradeUpdated> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2002.class);
	 
	 @Test
	 @Rollback
	 public void scenario2004(){
		 
		 given().i_am_a_staff_in_current_academic_session();
		 when().i_insert_grades();
		 then().student_grades_updated();
	 }

}
