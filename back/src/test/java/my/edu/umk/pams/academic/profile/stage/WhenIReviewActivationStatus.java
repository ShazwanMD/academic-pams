package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIReviewActivationStatus extends Stage<WhenIReviewActivationStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewActivationStatus.class);

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
	private AdStudentStatus studentStatus;


	public WhenIReviewActivationStatus I_review_activation_status_$(String identityNo) {

		student = identityService.findStudentByMatricNo(identityNo);
		LOG.debug("Student's Name:{}", student.getName());
		LOG.debug("Student's MatricNo:{}", student.getMatricNo());
		
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());
		
		faculty = plannerService.findFacultyByCode("A01");
		LOG.debug("Faculty Name :{}", faculty.getName());

		
		program = plannerService.findProgramByCodeAndFaculty("A01/PHD/0008", faculty);
		LOG.debug("Program CODE:{}", program.getCode());
		LOG.debug("Program Details:{}", program.getTitle());
		LOG.debug("Program Details:{}", program.getTitleEn());
		LOG.debug("Program Details:{}", program.getTitleMs());
		
		courses = plannerService.findCourses(faculty);
		for(AdCourse course:courses)
			LOG.debug("Course's Registered:{}", course.getCode());

		return self();
	}
	
	public WhenIReviewActivationStatus I_review_inactivation_status_$(String identityNo2) {

		student = identityService.findStudentByMatricNo(identityNo2);
		LOG.debug("Student's Name:{}", student.getName());
		LOG.debug("Student's MatricNo:{}", student.getMatricNo());
		
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());
		
		
		return self();
	}
	
	public WhenIReviewActivationStatus I_review_barred_status_$(String identityNo3) {

		student = identityService.findStudentByMatricNo(identityNo3);
		LOG.debug("Student's Name:{}", student.getName());
		LOG.debug("Student's MatricNo:{}", student.getMatricNo());
		
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());
		
		
		return self();
	}
	
	public WhenIReviewActivationStatus I_review_graduted_status_$(String identityNo4) {

		student = identityService.findStudentByMatricNo(identityNo4);
		LOG.debug("Student's Name:{}", student.getName());
		LOG.debug("Student's MatricNo:{}", student.getMatricNo());
		
		AdStudentStatus studentStatus = student.getStudentStatus();
		
		LOG.debug("Student's status: {}", studentStatus.name());
		LOG.debug("Student's status: {}", studentStatus.ordinal());
		
		
		return self();
	}

}
