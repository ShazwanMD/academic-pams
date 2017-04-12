package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenReviewMyCourseRegistration extends Stage<WhenReviewMyCourseRegistration> {

	@Pending
	public WhenReviewMyCourseRegistration i_want_to_view_course_registration() {

		return self();
		
	}

}
