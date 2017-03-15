package my.edu.umk.pams.academic.profile.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenIAddStudentProfile extends Stage<WhenIAddStudentProfile> {
	
	@Autowired
	private IdentityService identityService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdActor actor;

	public WhenIAddStudentProfile I_add_student_profile() {
		AdStudent student = new AdStudentImpl();

		student.setActorType(AdActorType.STUDENT);
		student.setIdentityNo("11111");
		student.setName("STUDENT ONE");

		identityService.saveStudent(student);

		return self();
	}

}
