package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;

@JGivenStage
public class ThenCourseRegistrationViewed extends Stage<ThenCourseRegistrationViewed> {

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private List<AdCourse> courses;

	public ThenCourseRegistrationViewed course_registration_viewed() {

		student.getIdentityNo();

		AdStudentStatus expectedStatus = student.getStudentStatus();
		AdStudentStatus actualStatus = student.getStudentStatus();
		Assert.isTrue(expectedStatus.equals(actualStatus), "exists");

		Assert.notNull(courses, "course is null");

		return self();

	}

}
