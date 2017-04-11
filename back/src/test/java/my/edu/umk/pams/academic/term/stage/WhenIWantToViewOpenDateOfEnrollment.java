package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIWantToViewOpenDateOfEnrollment extends Stage<WhenIWantToViewOpenDateOfEnrollment> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIEnrollTheCourses.class);

	
	public WhenIWantToViewOpenDateOfEnrollment I_want_to_view_open_date_of_enrollment() {
		return self();
	}
	
}



