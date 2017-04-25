package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIAmSetupExamVivaInfo extends Stage<WhenIAmSetupExamVivaInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmSetupExamVivaInfo.class);
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private PlannerService plannerService;
	@Autowired
	private TermService termService;
	
	
	@ExpectedScenarioState
	private static String staffNo;

	@ProvidedScenarioState
	private AdStaff staff;
	
	@Pending
	public WhenIAmSetupExamVivaInfo i_setup_assessment_info() {
	
		staff = identityService.findStaffByStaffNo(staffNo);
		LOG.debug("Staff name :{}", staff.getName());
		

		return self();

	}

}
