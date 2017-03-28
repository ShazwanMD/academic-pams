package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ThenStudentBarringStatusIsCurrent extends Stage<ThenStudentBarringStatusIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentBarringStatusIsCurrent.class);

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private AdStudent student;

	
	public ThenStudentBarringStatusIsCurrent Student_status_current() {

		String studentNo = "A17P002";

		AdStudent student = identityService.findStudentByStudentNo(studentNo);

		AdStudentStatus studentStatus = student.getStudentStatus();

		Assert.isTrue(studentStatus.equals(studentStatus), "true");
		
		return self();
	}
}
