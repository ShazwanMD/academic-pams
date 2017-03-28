package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenStudentBarringStatusIsCurrent extends Stage<ThenStudentBarringStatusIsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentBarringStatusIsCurrent.class);

	public ThenStudentBarringStatusIsCurrent Student_status_current() {

		return self();
	}
}
