package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenBursaryReviewStudentPaymentStatus extends Stage<WhenBursaryReviewStudentPaymentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBursaryReviewStudentPaymentStatus.class);
	
	
	
	@Pending
	public WhenBursaryReviewStudentPaymentStatus Bursary_review_student_payment_status() {
		
		
		return self();
		
	}

}
