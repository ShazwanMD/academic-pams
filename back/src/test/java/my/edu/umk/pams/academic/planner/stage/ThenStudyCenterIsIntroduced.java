package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.service.PlannerService;

/**
 * @author zaida_nawi
 **/
@JGivenStage
public class ThenStudyCenterIsIntroduced extends Stage<ThenStudyCenterIsIntroduced> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudyCenterIsIntroduced.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdStudyCenterCode studyCenterCode;

	public ThenStudyCenterIsIntroduced study_center_is_intoduced() {

		AdStudyCenterCode studyCenterCode = commonService.findStudyCenterCodeByCode("E");
		LOG.debug("Study Center Code is intoduced: {} ", studyCenterCode.getCode());
		LOG.debug("Study Center Description is intoduced: {} ", studyCenterCode.getDescription());
		Assert.notNull(studyCenterCode, "Study Center data is intoduced");
		return self();

	}
}