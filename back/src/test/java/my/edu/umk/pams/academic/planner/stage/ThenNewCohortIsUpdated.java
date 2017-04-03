package my.edu.umk.pams.academic.planner.stage;
/*Given : I Am Admin
When : Admin Update Cohort 
Then :  New Cohort Is Updated.
@author zaida_n
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;



@JGivenStage
public class ThenNewCohortIsUpdated extends Stage<ThenNewCohortIsUpdated >{
	
	 @Autowired
	    private PlannerService plannerService;

	    @ExpectedScenarioState
	    private AdProgram program;

	    public ThenNewCohortIsUpdated new_cohort_is_updated() {
	        List<AdCohort> cohort = plannerService.findCohorts(program, 0, 100);
	        Assert.notEmpty(cohort, "Cohort should not be empty");
	        return self();
	    }
}
