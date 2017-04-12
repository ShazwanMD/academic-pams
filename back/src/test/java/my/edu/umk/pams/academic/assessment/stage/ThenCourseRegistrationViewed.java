package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenCourseRegistrationViewed extends Stage<ThenCourseRegistrationViewed> {

	@Pending
	public ThenCourseRegistrationViewed course_registration_viewed() {
		
		return self();
		
	}

}
