package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;

@JGivenStage
public class WhenAdminUpdateStudyCenter extends Stage<WhenAdminUpdateStudyCenter> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateStudyCenter.class);

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdStudyCenter studyCenterCode;

	@ExpectedScenarioState
	private String CODE;

	public WhenAdminUpdateStudyCenter Admin_update_study_center_$(String CODE) {

		// update study center code for CODE = "A"
		studyCenterCode = commonService.findStudyCenterByCode(CODE);
		studyCenterCode.setCode("F");
		studyCenterCode.setDescription("KAMPUS KUCHING");
		commonService.updateStudyCenter(studyCenterCode);
		
		//view update study center code
		LOG.debug("StudyCentreCode:{}", studyCenterCode.getCode());
		return self();

	}

}
