package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenLecturerReviewedCourseAndResearchInfo extends Stage<ThenLecturerReviewedCourseAndResearchInfo> {
	
private static final Logger LOG = LoggerFactory.getLogger(ThenLecturerReviewedCourseAndResearchInfo.class);
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	AdStudent student;
	
	@ExpectedScenarioState
	AdCourse course;	
	
	@ExpectedScenarioState
	AdProgram program;
	
	@ExpectedScenarioState
	AdFaculty faculty;	
	
	public ThenLecturerReviewedCourseAndResearchInfo Lecturer_review_course_info_for_$(String identityNo){
		
		student = identityService.findStudentByMatricNo(identityNo);
		faculty = program.getFaculty();
		
		boolean exists = plannerService.isCourseExists("MCM", faculty);
		
		Assert.isTrue(exists, "is not exists");
		
		return self();
	}
	
	public ThenLecturerReviewedCourseAndResearchInfo Lecturer_review_research_info_for_$(String identityNo2){
		
		student = identityService.findStudentByMatricNo(identityNo2);
		faculty = program.getFaculty();
		
		boolean exists = plannerService.isCourseExists("PCV", faculty);
		
		Assert.isTrue(exists, "is not exists");
		
		return self();
	}

}
