package my.edu.umk.pams.academic.profile.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenStudentRegisteredCoursesReviewed extends Stage<ThenStudentRegisteredCoursesReviewed> {

	
	@Pending
	public ThenStudentRegisteredCoursesReviewed student_registration_courses_reviewed() {

		return self();
	}

}
