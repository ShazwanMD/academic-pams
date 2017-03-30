package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenCourseRegistrationDetailReviewed extends Stage<ThenCourseRegistrationDetailReviewed> {

	@Pending
	public ThenCourseRegistrationDetailReviewed  course_registration_details_reviewed() {
		
		return self();
	}

}
