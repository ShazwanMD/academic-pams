package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenStudentDetailsCurrent extends Stage<ThenStudentDetailsCurrent> {

	@Pending
	public ThenStudentDetailsCurrent student_details_current() {
		
		return self();
		
	}

}
