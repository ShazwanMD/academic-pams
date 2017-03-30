package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenReviewCourseRegistrationDetails extends Stage<WhenReviewCourseRegistrationDetails>{

	@Pending
	public WhenReviewCourseRegistrationDetails supervisor_review_course_registration_info() {
		
		
		return self();
	}

}
