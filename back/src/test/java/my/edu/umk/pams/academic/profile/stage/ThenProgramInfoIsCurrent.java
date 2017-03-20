package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenProgramInfoIsCurrent extends Stage<ThenProgramInfoIsCurrent> {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private String code;
	

	private boolean exists;

	public ThenProgramInfoIsCurrent Program_info_is_current() {
		exists = studyplanService.isProgramExists("FIAT/PHD/0001", faculty);
		Assert.isTrue(exists, "program exists");
		return self();
	}
}
