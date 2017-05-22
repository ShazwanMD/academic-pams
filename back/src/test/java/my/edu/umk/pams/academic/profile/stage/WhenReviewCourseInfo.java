package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenReviewCourseInfo extends Stage<WhenReviewCourseInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenReviewCourseInfo.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdCourse course;

    @ExpectedScenarioState
    private String code;

    @ExpectedScenarioState
    private AdFaculty faculty;

    public WhenReviewCourseInfo I_view_course_info_for_faculty_$(String facultyCode) {
        faculty = plannerService.findFacultyByCode(facultyCode);

       List <AdCourse> courses = faculty.getCourses();
       for (AdCourse course : courses) {
            LOG.debug(course.getTitleEn());
        }
        return self();
    }

}
