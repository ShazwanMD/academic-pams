package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdFacultyImpl;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIWantToViewTheCourseForMyProgram extends Stage<WhenIWantToViewTheCourseForMyProgram> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewTheCourseForMyProgram.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private List<AdCourse> course;

    @ExpectedScenarioState
    private String code;

    @ExpectedScenarioState
    private AdFaculty faculty;

    public WhenIWantToViewTheCourseForMyProgram() {
        AdFaculty faculty = new AdFacultyImpl();
    }

    public WhenIWantToViewTheCourseForMyProgram I_want_to_view_the_course_for_faculty_$(String code) {

        faculty = studyplanService.findFacultyByCode(code);

        course = studyplanService.findCourses(faculty);

        for (AdCourse course : course) {
            LOG.debug(course.getTitle());
        }
        return self();
    }

}