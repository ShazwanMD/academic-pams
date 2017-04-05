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
	AdFaculty faculty;	
	
	public ThenLecturerReviewedCourseAndResearchInfo Lecturer_review_course(){
		faculty = plannerService.findFacultyByCode("A10");
		boolean exists = plannerService.isCourseExists("MBA/GST 5013", faculty);
		
		Assert.isTrue(exists, "is not exists");
		
		return self();
	}
	
	public ThenLecturerReviewedCourseAndResearchInfo Lecturer_review_research_info(){
		faculty = plannerService.findFacultyByCode("CPS");
		boolean exists = plannerService.isCourseExists("MAP", faculty);
		
		Assert.isTrue(exists, "is not exists");
		
		return self();
	}

}
