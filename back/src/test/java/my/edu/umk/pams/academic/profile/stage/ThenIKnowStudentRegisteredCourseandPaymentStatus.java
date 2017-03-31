package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;

import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;


@JGivenStage
public class ThenIKnowStudentRegisteredCourseandPaymentStatus extends Stage<ThenIKnowStudentRegisteredCourseandPaymentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenIKnowStudentRegisteredCourseandPaymentStatus.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	private	AdStudent student;
	
	@ExpectedScenarioState
	private AdCourse course;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	
	
	@Pending
	public ThenIKnowStudentRegisteredCourseandPaymentStatus student_registered_courses_and_payment_status_is_viewed() {


		return self();
	}

}
