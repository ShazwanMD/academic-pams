package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenPrerequisiteRemove extends Stage<WhenPrerequisiteRemove> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenPrerequisiteRemove.class);
    @Autowired
    private PlannerService plannerService;
    
    public WhenPrerequisiteRemove remove_prereq_$_to_course_$(String prereqCode, String courseCode) {

        AdCourse course = plannerService.findCourseByCode(courseCode);
        LOG.debug(" course code: {}", course.getCode());

        AdCourse prereqCourse = plannerService.findCourseByCode(prereqCode);
        LOG.debug(" course prerequisite: {}", prereqCourse.getCode());

        plannerService.removePrerequisite(course, prereqCourse);
        
        LOG.debug("================remove data================== ");
        LOG.debug("course code : {}", course.getCode());
        LOG.debug("prerequisite: {}", prereqCourse.getCode());

        return self();

    }

}
