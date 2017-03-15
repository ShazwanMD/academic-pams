package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.bdd.stage.GivenIAmStudent;

@JGivenStage
public class WhenIUpdateStudentProfileInfo extends Stage<WhenIUpdateStudentProfileInfo>  {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateStudentProfileInfo.class);
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired 
	private CommonService commonService;
	
	@ProvidedScenarioState
	private AdStudent student;
	

	
	public WhenIUpdateStudentProfileInfo I_update_student_profile_info() {

		return self();
	}

}
