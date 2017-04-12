package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIViewStudentInfo extends Stage<WhenIViewStudentInfo>  {
	
	public WhenIViewStudentInfo i_view_student_info() {

		return self();
	}


}
