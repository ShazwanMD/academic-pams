package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheAdmissionWillBeReviewed extends Stage<ThenTheAdmissionWillBeReviewed> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionWillBeReviewed.class);

	@Autowired
	private TermService termService;

	public ThenTheAdmissionWillBeReviewed The_admission_will_be_reviewed() {

		//process reviewed
		
		return self();

	}

}

