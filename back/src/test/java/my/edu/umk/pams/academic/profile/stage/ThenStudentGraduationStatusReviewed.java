package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;



@JGivenStage
public class ThenStudentGraduationStatusReviewed extends Stage<ThenStudentGraduationStatusReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentGraduationStatusReviewed.class);
	
	
	@Pending
	public ThenStudentGraduationStatusReviewed Student_Graduation_Status_Reviewed() {
		
		return self();
		
	}

}
