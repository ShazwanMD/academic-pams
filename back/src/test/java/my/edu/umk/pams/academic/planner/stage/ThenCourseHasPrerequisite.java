package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 * @author ain_zaida
 */

@JGivenStage
public class ThenCourseHasPrerequisite extends Stage<ThenCourseHasPrerequisite> {

    @Autowired
    private PlannerService plannerService;

    public ThenCourseHasPrerequisite course_$_is_a_prereq_for_course_$(String prereqCode, String courseCode) {

        AdCourse course = plannerService.findCourseByCode(courseCode);

        List<AdCoursePrerequisite> prerequisites = course.getPrerequisites();
        String actualCode = prerequisites.get(0).getPrerequisite().getCode();

        String message1 = "Expected " + prereqCode + ", found " + actualCode;
        Assert.isTrue(prereqCode.equals(actualCode), message1);

        return self();
    }

}
