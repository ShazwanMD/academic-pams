package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

@JGivenStage
public class ThenStudentDetailsCurrent extends Stage<ThenStudentDetailsCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentDetailsCurrent.class);

	@Autowired
	private IdentityService identityService;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdProgramLevel level;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	public String matricNo;
	
	public ThenStudentDetailsCurrent student_details_current() {
		student = identityService.findStudentByMatricNo(matricNo);

		Assert.notNull(matricNo, "Student Must NOT NULL");
		return self();

	}

}
