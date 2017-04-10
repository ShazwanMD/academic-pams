package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 *    
 * @author ain
 */

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.US_AD_PNR_1006;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminAddCoursePrerequisite extends Stage<WhenAdminAddCoursePrerequisite> {
	
	    @Autowired
	    private PlannerService plannerService;
	    
	    @ProvidedScenarioState
	    private AdCourse course ;
	    
	    @ProvidedScenarioState
	    private AdCoursePrerequisite coursePrerequisite ;

	    
	    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddCoursePrerequisite.class);

	public WhenAdminAddCoursePrerequisite Admin_add_prereq_$_to_course_$(String courseCodePrereq, String courseCode) {

		
		AdCourse course = plannerService.findCourseByCode("DDA2103");
		LOG.debug(" course code: {}", course.getCode());
		
		AdCourse prereqCourse = plannerService.findCourseByCode("DDA2113");
		LOG.debug(" course prerequisite: {}", prereqCourse.getCode());
		

    	plannerService.addPrerequisites(course, prereqCourse);
    	
    	
    	
        return self();

    }

}
