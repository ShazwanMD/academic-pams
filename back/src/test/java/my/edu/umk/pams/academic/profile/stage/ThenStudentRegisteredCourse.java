package my.edu.umk.pams.academic.profile.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenStudentRegisteredCourse extends Stage<ThenStudentRegisteredCourse> {

	@Autowired
	private PlannerService plannerService;
	@Autowired
	private IdentityService identityService;
	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdActor actor;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private AdFaculty faculty;



	public ThenStudentRegisteredCourse Student_registered_course() {
		String studentNo = "A17P001";

		AdStudent student = identityService.findStudentByMatricNo(studentNo);

		AdStudentStatus studentStatus = student.getStudentStatus();

		Assert.isTrue(studentStatus.equals(studentStatus), "true");

		
		
		return self();

	}

}
