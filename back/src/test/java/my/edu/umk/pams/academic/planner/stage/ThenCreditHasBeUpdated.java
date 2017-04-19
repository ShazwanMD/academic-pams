package my.edu.umk.pams.academic.planner.stage;
/*
 * @author zaida
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenCreditHasBeUpdated extends Stage<ThenCreditHasBeUpdated>{

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@Autowired
	private PlannerService plannerService;

	public ThenCreditHasBeUpdated Credit_has_be_updated() {
		
		return self();
	}
	}
