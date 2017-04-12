package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenICanViewStudentSubjectRegistered extends Stage<ThenICanViewStudentSubjectRegistered> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenICanViewStudentSubjectRegistered.class);
	
    public ThenICanViewStudentSubjectRegistered i_can_view_student_subject_registered() {
		
		return self();
		
    }	

}
