package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenLecturerReviewedStudentGraduationStatus extends Stage<ThenLecturerReviewedStudentGraduationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenLecturerReviewedStudentGraduationStatus.class);
	
	@Pending
	public ThenLecturerReviewedStudentGraduationStatus Lecturer_reviewed_student_graduation_status() {
		
		return self();
		
	}

}
