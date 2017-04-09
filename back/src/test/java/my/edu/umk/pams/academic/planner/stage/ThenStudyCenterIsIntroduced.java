package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
/**
 * @author zaida_nawi
 **/
public class ThenStudyCenterIsIntroduced extends Stage<ThenStudyCenterIsIntroduced>{
	
	@Autowired
	private PlannerService plannerService;
	
	
	@Autowired
	private CommonService commonService;

	    @ExpectedScenarioState
		private AdStudyCenterCode studyCenterCode;

	    public ThenStudyCenterIsIntroduced study_center_is_intoduced() {
	        return self();

}
}