package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenBursaryReviewStudentGraduationStatus extends Stage<WhenBursaryReviewStudentGraduationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBursaryReviewStudentGraduationStatus.class);
	
	
	
	
	@Pending
	public WhenBursaryReviewStudentGraduationStatus Bursary_Review_Student_Graduation_Status() {
	
		return self();
	
	}

}
