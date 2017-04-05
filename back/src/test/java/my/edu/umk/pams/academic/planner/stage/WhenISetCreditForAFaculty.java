package my.edu.umk.pams.academic.planner.stage;

/*Given : I Am Admin
 * When : Admin Set Credit
 * Then :  Set Credit Has Introduced.
 * @author zaida
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

public class WhenISetCreditForAFaculty extends Stage<WhenISetCreditForAFaculty> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenISetCreditForAFaculty.class);

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private String code;

	public WhenISetCreditForAFaculty I_set_credit_for_a_faculty() {
		faculty = plannerService.findFacultyByCode(code);

		return null;

	}
}