package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenExamVivaCreated extends Stage<ThenExamVivaCreated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenExamVivaCreated.class);

	@Pending
	public ThenExamVivaCreated exam_viva_created() {

		return self();

	}

}
