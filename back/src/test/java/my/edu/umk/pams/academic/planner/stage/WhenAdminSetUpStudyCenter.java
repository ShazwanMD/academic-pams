package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.common.model.AdStudyCenterCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zaida_nawi
 **/
@JGivenStage
public class WhenAdminSetUpStudyCenter extends Stage<WhenAdminSetUpStudyCenter> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminSetUpStudyCenter.class);

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdStudyCenterCode studyCenterCode;

	public WhenAdminSetUpStudyCenter Admin_set_up_study_center() {

		AdStudyCenterCode studyCenterCode = new AdStudyCenterCodeImpl();

		studyCenterCode.setCode("E");
		studyCenterCode.setDescription("UMK Campus Kucing");

		commonService.saveStudyCenterCode(studyCenterCode);

		LOG.debug("test{} :", studyCenterCode.getDescription());
		LOG.debug("test{} :", studyCenterCode.getCode());
		LOG.debug("studyCenter  :{}", studyCenterCode);

		return self();

	}

}
