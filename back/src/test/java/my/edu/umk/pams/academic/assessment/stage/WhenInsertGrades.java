package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenInsertGrades extends Stage<WhenInsertGrades> {

	@Pending
	public WhenInsertGrades insert_student_grades() {
		
		return self();
		
	}

}
