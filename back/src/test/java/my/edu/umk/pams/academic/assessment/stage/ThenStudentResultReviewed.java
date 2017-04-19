package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenStudentResultReviewed extends Stage<ThenStudentResultReviewed > {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentResultReviewed.class);
	
//	@Autowired
//	private CommonService commonService;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private TermService termService;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdAssessment assessment;

	@ExpectedScenarioState
	private String matricNo;
	
	@ExpectedScenarioState
	private AdGradeCode grade;
	
	@ExpectedScenarioState
	private int mark;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ExpectedScenarioState
	private AdOffering offering;
	
	public ThenStudentResultReviewed result_student_reviewed() {

		student = identityService.findStudentByMatricNo(matricNo);
		Assert.notNull(student, "Student must not null");
		 
		boolean exists = termService.hasAssessment(academicSession, offering);
		Assert.isTrue(exists, "exists");
			
			return self();
	}
}
