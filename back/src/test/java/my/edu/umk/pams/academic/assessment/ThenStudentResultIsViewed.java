package my.edu.umk.pams.academic.assessment;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;


@JGivenStage
public class ThenStudentResultIsViewed extends Stage<ThenStudentResultIsViewed> {
	
	@Pending
	public ThenStudentResultIsViewed supervisor_view_result_student() {

		return self();
		
	}

}
