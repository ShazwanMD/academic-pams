package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdBundleSubject;
import my.edu.umk.pams.academic.planner.model.AdSingleSubject;
import org.springframework.util.Assert;

@JGivenStage
public class ThenSubjectAdded extends Stage<ThenSubjectAdded> {

	@ExpectedScenarioState
	AdBundleSubject bundleSubject;

	@ExpectedScenarioState
	AdSingleSubject singleSubject;


	public ThenSubjectAdded subject_added() {

		Assert.notNull(bundleSubject, "bundleSubject cannot be null");
		Assert.notNull(singleSubject, "singleSubject cannot be null");

		return self();
	}

}
