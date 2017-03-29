package my.edu.umk.pams.academic.planner.stage;

/**
 * @author zaida_Ain
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;

public class WhenISetCreditForAFaculty extends Stage<WhenISetCreditForAFaculty> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenISetCreditForAFaculty.class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private String code;
	
	public WhenISetCreditForAFaculty I_set_credit_for_a_faculty(){
		return null;

	}
}