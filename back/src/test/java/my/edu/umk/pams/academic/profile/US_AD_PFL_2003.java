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
	import my.edu.umk.pams.academic.profile.stage.ThenStudentStatusCurrent;
	import my.edu.umk.pams.academic.profile.stage.WhenIWantViewStudentStatus;
	import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;

	@RunWith(SpringJUnit4ClassRunner.class)
	@Transactional
	@ContextConfiguration(classes = TestAppConfiguration.class)
	public class US_AD_PFL_2003 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIWantViewStudentStatus, ThenStudentStatusCurrent> {

		
		private static final Logger LOG = LoggerFactory.getLogger(US_AD_PFL_2003.class);
		
		
		private String IDENTITY_NO = "A17P001";
		
		
		
		@Test
		@Rollback
		public void scenario2003(){
			
			given().I_am_a_CPS_administrator_in_current_academic_session();
			when().I_view_student_current_status_for_$(IDENTITY_NO);
			then().Student_status_is_current();
		}
	}



