package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
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
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    AdFaculty faculty;

    // todo(uda): better ways to assert
    public ThenFacultyHasCourse faculty_has_courses() {
        List<AdCourse> courses = studyplanService.findCourses(faculty);
        Assert.notEmpty(courses, "courses cannot be empty");
        return self();
    }
}
