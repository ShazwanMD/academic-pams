package my.edu.umk.pams.academic.profile.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenOfferedCoursesAndStudentsAreViewed extends Stage<ThenOfferedCoursesAndStudentsAreViewed> {

	
	@Pending
	public ThenOfferedCoursesAndStudentsAreViewed I_view_students_registered_in_my_class() {

		return self();
	}

}
