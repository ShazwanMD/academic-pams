package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenLecturerReviewCourseInfoAndResearchInfo extends Stage<WhenLecturerReviewCourseInfoAndResearchInfo> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenLecturerReviewCourseInfoAndResearchInfo.class);
	
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
	
	public WhenLecturerReviewCourseInfoAndResearchInfo Lecturer_review_course_info_for_$(String identityNo){
		
		student = identityService.findStudentByMatricNo(identityNo);
		LOG.debug("Student's Name :{}", student.getName());
		
		faculty = plannerService.findFacultyByCode("A10");
		LOG.debug("Faculty's Details :{}", faculty.getDescription());
		
		course = plannerService.findCourseByCodeAndFaculty("MBA/GST 5013", faculty);
		LOG.debug("Course's Details :{}", course.getCode());
		LOG.debug("Course's Details :{}", course.getTitle());
		LOG.debug("Course's Details :{}", course.getTitleEn());
		LOG.debug("Course's Details :{}", course.getTitleMs());
		
		
		return self();
		
		
	}
	
	public WhenLecturerReviewCourseInfoAndResearchInfo Lecturer_review_research_info_for_$(String identityNo2){
		
		student = identityService.findStudentByMatricNo(identityNo2);
		LOG.debug("Student's Name :{}", student.getName());
		
		faculty = plannerService.findFacultyByCode("CPS");
		LOG.debug("Faculty's Details :{}", faculty.getDescription());
		
		course = plannerService.findCourseByCodeAndFaculty("MAP", faculty);
		LOG.debug("Research's Details :{}", course.getCode());
		LOG.debug("Research's Details :{}", course.getTitle());
		LOG.debug("Research's Details :{}", course.getTitleEn());
		LOG.debug("Research's Details :{}", course.getTitleMs());
		
		
		return self();
		
		
	}

	

}
