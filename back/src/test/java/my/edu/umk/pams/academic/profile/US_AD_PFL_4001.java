package my.edu.umk.pams.academic.profile;

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
import my.edu.umk.pams.academic.profile.stage.ThenOfferedCoursesAndStudentsAreViewed;
import my.edu.umk.pams.academic.profile.stage.WhenReviewEnrollmentDetails;
import my.edu.umk.pams.bdd.stage.GivenIAmAcademicStaff;

/* As a lecturer/academic staff,
 * 		I review enrollment details,
 * 			so that I know offered courses registered by the students under my classes
 */



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration (classes = TestAppConfiguration.class)

public class US_AD_PFL_4001 extends SpringScenarioTest <GivenIAmAcademicStaff, WhenReviewEnrollmentDetails, ThenOfferedCoursesAndStudentsAreViewed>{

	private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_4001.class);
    
	public static final String SCTN_canonicalCode = "FKP/PHD/0001/DDA2113/201720181";
	public static final String OFRG_canonicalCode = "FKP/PHD/0001/DDA2113";
				
	@Test
	@Rollback
	public void scenario4001() {
		given().i_am_a_staff_in_current_academic_session().
			and().i_pick_offering_$(OFRG_canonicalCode).
				and().i_pick_section_$(SCTN_canonicalCode);
		
		when().review_enrollment_details();
		then().I_view_students_registered_in_my_class();
	}
	
	
}
