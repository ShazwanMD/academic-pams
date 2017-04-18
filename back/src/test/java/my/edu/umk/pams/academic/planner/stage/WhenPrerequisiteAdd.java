package my.edu.umk.pams.academic.planner.stage;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 *    
 * @author ain
 */

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenPrerequisiteAdd extends Stage<WhenPrerequisiteAdd> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenPrerequisiteRemove.class);

    @Autowired
    private PlannerService plannerService;

    public WhenPrerequisiteAdd I_add_prereq_$_to_course_$(String courseCodePrereq, String courseCode) {

        AdCourse course = plannerService.findCourseByCode(courseCode);
        AdCourse prereqCourse = plannerService.findCourseByCode(courseCodePrereq);

        plannerService.addPrerequisites(course, prereqCourse);
        
        LOG.debug("================add data================== ");
        LOG.debug("course code: {}", course.getCode());
        LOG.debug("prerequisite: {}", prereqCourse.getCode());

        return self();

    }

}
