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

import my.edu.umk.pams.academic.assessment.stage.ThenExamVivaUpdated;
import my.edu.umk.pams.academic.assessment.stage.WhenIAmUpdateExamVivaInfo;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a supervisor, I want to update exam/viva info So that I can update exam/viva information")
public class US_AD_ASMT_2002 extends SpringScenarioTest<GivenIAmAcademicStaff, WhenIAmUpdateExamVivaInfo, ThenExamVivaUpdated> {
	

    private static final Logger LOG = LoggerFactory.getLogger(US_AD_ASMT_2002.class);

   
    

    @Test
    @Rollback
    public void scenarioEXAM() throws Exception {
        given().i_am_a_staff_in_current_academic_session();
        when().i_update_examination_info();
        then().exam_info_updated();
    }
    
    @Test
    @Rollback
    public void scenarioVIVA() {
        given().i_am_a_staff_in_current_academic_session();
        when().i_update_viva_info();
        then().viva_info_updated();
    }
}
