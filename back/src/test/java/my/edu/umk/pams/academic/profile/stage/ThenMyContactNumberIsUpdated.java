package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenMyContactNumberIsUpdated extends Stage<ThenMyContactNumberIsUpdated> {

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private String identityNo;

	@SuppressWarnings("deprecation")
	public ThenMyContactNumberIsUpdated my_contact_number_is_updated() {

		Assert.notNull(actor);
		return self();

	}

}
