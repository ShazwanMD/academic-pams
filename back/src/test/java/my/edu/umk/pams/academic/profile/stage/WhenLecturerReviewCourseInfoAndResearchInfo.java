package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
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
public class WhenLecturerReviewCourseInfoAndResearchInfo extends Stage<WhenLecturerReviewCourseInfoAndResearchInfo> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenLecturerReviewCourseInfoAndResearchInfo.class);
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	AdStudent student;
	
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


	public WhenLecturerReviewCourseInfoAndResearchInfo Lecturer_review_course_info_for_$(String identityNo){
		
		student = identityService.findStudentByMatricNo(identityNo);
		LOG.debug("Student's Name :{}", student.getName());
		
		studentStatus = student.getStudentStatus();
		LOG.debug("Student Status:{}", studentStatus.name());
		
		cohort = student.getCohort();
				
		program = cohort.getProgram();
		LOG.debug("Program:{}", program.getTitle());
	    
		faculty = program.getFaculty();
	    LOG.debug("Faculty:{}", faculty.getName());
	    
	    level = program.getProgramLevel();
	    LOG.debug("Level :{}", level.getCode());
	    	    
	    courses = faculty.getCourses();
		for(AdCourse course:courses)
			LOG.debug("Course(s):{}", course.getCode());
		
		
	
		
//		course = plannerService.findCourseByCodeAndFaculty("MBA/GST 5013", faculty);
//		LOG.debug("Course's Details :{}", course.getCode());
//		LOG.debug("Course's Details :{}", course.getTitle());
//		LOG.debug("Course's Details :{}", course.getTitleEn());
//		LOG.debug("Course's Details :{}", course.getTitleMs());
//		
		
		return self();
		
		
	}
	@Pending
	public WhenLecturerReviewCourseInfoAndResearchInfo Lecturer_review_research_info_for_$(String identityNo2){
		
//		student = identityService.findStudentByMatricNo(identityNo2);
//		faculty = plannerService.findFacultyByCode("CPS");
//		course = plannerService.findCourseByCodeAndFaculty("MAP", faculty);
//		
//		
//		LOG.debug("Student's Name :{}", student.getName());
//		
//
//		LOG.debug("Faculty's Details :{}", faculty.getDescription());
//		
//
//		LOG.debug("Research's Details :{}", course.getCode());
//		LOG.debug("Research's Details :{}", course.getTitle());
//		LOG.debug("Research's Details :{}", course.getTitleEn());
//		LOG.debug("Research's Details :{}", course.getTitleMs());
//		
//		
		return self();
		
		
	}

	

}
