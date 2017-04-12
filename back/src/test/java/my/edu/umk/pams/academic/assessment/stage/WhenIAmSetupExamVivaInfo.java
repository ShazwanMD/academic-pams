package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIAmSetupExamVivaInfo extends Stage<WhenIAmSetupExamVivaInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmSetupExamVivaInfo.class);

	@Pending
	public WhenIAmSetupExamVivaInfo i_setup_exam_viva_info() {

		return self();

	}

}
