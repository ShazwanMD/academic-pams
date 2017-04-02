package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;



@JGivenStage
public class WhenReviewStudentBarringStatus extends Stage<WhenReviewStudentBarringStatus> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentBarringStatus.class);
	
    @ExpectedScenarioState
    private AdStudent student;
	
    @Pending
	public WhenReviewStudentBarringStatus I_view_student_$_barring_status(String identityNo){
		


		return self();
	}
}
