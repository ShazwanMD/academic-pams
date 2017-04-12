package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenGradesIsUpdated extends Stage<ThenGradesIsUpdated>{

	@Pending
	public ThenGradesIsUpdated student_grades_updated() {
		
		return self();
			
	}

}
