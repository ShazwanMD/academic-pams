package my.edu.umk.pams.academic.planner.stage;

/*Given : I Am Admin
When : Admin Update Cohort 
Then :  New Cohort Is Updated.
@author zaida_n
*/

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;


@JGivenStage
public class WhenAdminUpdateCohort extends Stage<WhenAdminUpdateCohort>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateCohort.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	public void Admin_update_cohort_to_faculty_code_$(String facultyCode) {

}
}