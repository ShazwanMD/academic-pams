package my.edu.umk.pams.academic.planner.stage;

/*
 * @author zaida
 */
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenCreditHasBeUpdated extends Stage<ThenCreditHasBeUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenCreditHasBeUpdated.class);
			
	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdCourse course;

	@Autowired
	private PlannerService plannerService;

	public ThenCreditHasBeUpdated Credit_has_be_updated_$(Integer credit) {

		Integer expected = credit;
		Integer found = course.getCredit();
		String message = "expected " + expected + ", found " + found;
		Assert.isTrue(Objects.equals(found, credit), message);
		LOG.debug("updated credit = {}", course.getCredit());
		
		return self();
	}
}
