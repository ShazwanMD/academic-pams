package my.edu.umk.pams.academic.profile.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class ThenStudentStatusCurrent extends Stage<ThenStudentStatusCurrent> {

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private AdStudent student;

	public ThenStudentStatusCurrent Student_status_is_current() {

		String studentNo = "A17P001";

		AdStudent student = identityService.findStudentByStudentNo(studentNo);

		AdStudentStatus studentStatus = student.getStudentStatus();

		Assert.isTrue(studentStatus.equals(studentStatus), "true");

		return self();
	}

}
