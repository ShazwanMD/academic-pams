package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.common.service.CommonService;

@JGivenStage
public class ThenStudyCenterUpdated extends Stage<ThenStudyCenterUpdated> {

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdStudyCenterCode studyCenterCode;

	private static final Logger LOG = LoggerFactory.getLogger(ThenProgramUpdated.class);

	public ThenStudyCenterUpdated Study_Center_is_updated() {

		LOG.debug("Study Center Code has been updated: {} ", studyCenterCode.getCode());
		LOG.debug("Study Center Description has been updated: {} ", studyCenterCode.getDescription());
		Assert.notNull(studyCenterCode, "Study Center data has been updated");

		return self();

	}
}
