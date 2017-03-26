package my.edu.umk.pams.academic.profile.stage;

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

@JGivenStage
public class ThenInformationUpdated extends Stage<ThenInformationUpdated> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenInformationUpdated.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    AdFaculty faculty;

    public ThenInformationUpdated Information_updated() {

        List<AdCourse> courses = plannerService.findCourses(faculty);
        Assert.notEmpty(courses, "Courses cannot be empty");
        return self();
    }

}
