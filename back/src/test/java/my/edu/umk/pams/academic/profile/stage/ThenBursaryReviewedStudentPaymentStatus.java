package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenBursaryReviewedStudentPaymentStatus extends Stage<ThenBursaryReviewedStudentPaymentStatus> {

	
	private static final Logger LOG = LoggerFactory.getLogger(ThenBursaryReviewedStudentPaymentStatus.class);
	
	
	@Pending
	public ThenBursaryReviewedStudentPaymentStatus Student_payment_status_reviewed() {
		
		
		return self();
		
	}

}
