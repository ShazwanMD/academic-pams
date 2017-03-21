package my.edu.umk.pams.academic.profile.stage;

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

@JGivenStage
public class ThenInformationUpdated extends Stage<ThenInformationUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenInformationUpdated.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    AdFaculty faculty;

    public ThenInformationUpdated Information_updated() {

        List<AdCourse> courses = studyplanService.findCourses(faculty);
        Assert.notEmpty(courses, "Courses cannot be empty");
        return self();
    }

}
