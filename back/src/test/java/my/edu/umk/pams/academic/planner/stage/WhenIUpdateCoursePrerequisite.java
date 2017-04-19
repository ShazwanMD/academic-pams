package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIUpdateCoursePrerequisite  extends Stage<WhenIUpdateCoursePrerequisite>  {
	
	  @Autowired
	    private PlannerService plannerService;
	    
	    @ProvidedScenarioState
	    private AdCourse course ;
	    
	    @ProvidedScenarioState
	    private AdCoursePrerequisite coursePrerequisite ;
	    

	    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddCoursePrerequisite.class);


		public WhenIUpdateCoursePrerequisite Admin_update_prereq_$_to_course_$(String prereqCode, String courseCode) {
			
			AdCourse course = plannerService.findCourseByCode(courseCode);
			LOG.debug(" course code: {}", course.getCode());
			
			AdCourse prereqCourse = plannerService.findCourseByCode(prereqCode);
			LOG.debug(" course prerequisite: {}", prereqCourse.getCode());
			

	    	plannerService.updatePrerequisite(course, prereqCourse);
	    	
	    	
			
			
			
			return self();
			
			
		}
	    
	    
}
		
