package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenBursaryReviewStudentGraduationStatus extends Stage<WhenBursaryReviewStudentGraduationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBursaryReviewStudentGraduationStatus.class);
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;

    @ExpectedScenarioState
	private AdStudent student;
    
    @ExpectedScenarioState
   	private AdProgram program;
    
    @ExpectedScenarioState
   	private AdProgramLevel level;
    
    @ExpectedScenarioState
   	private List<AdCourse> courses;
    
    @ExpectedScenarioState
   	private AdFaculty faculty;
    
    @ExpectedScenarioState
   	private AdCohort cohort;

    @ExpectedScenarioState
	private AdStudentStatus studentStatus;
	
	
	public WhenBursaryReviewStudentGraduationStatus bursary_review_student_graduation_status(String identityNo) {
		student = identityService.findStudentByMatricNo(identityNo);
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		if(studentStatus == AdStudentStatus.GRADUATED){
		LOG.debug("Student's name: {}", student.getName());
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Congratulations");
		
		}else {
			
			LOG.debug("Not Qualify to graduate");
		}
		return self();
	
	}

}
