package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenFacultyHasCourse extends Stage<ThenFacultyHasCourse> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenFacultyHasCourse.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    AdFaculty faculty;

    // todo(uda): better ways to assert
    public ThenFacultyHasCourse faculty_has_courses() {
        List<AdCourse> courses = plannerService.findCourses(faculty);
        Assert.notEmpty(courses, "courses cannot be empty");
        return self();
    }
}
