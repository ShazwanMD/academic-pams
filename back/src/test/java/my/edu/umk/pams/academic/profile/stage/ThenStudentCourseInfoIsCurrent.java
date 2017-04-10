package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenStudentCourseInfoIsCurrent extends Stage<ThenStudentCourseInfoIsCurrent> {


    @Autowired
    private ProfileService profileService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdCourse course;

    @ExpectedScenarioState
    private AdFaculty faculty;

    public ThenStudentCourseInfoIsCurrent student_course_info_is_current() {
//        boolean exists = plannerService.isProgramExists("A01/MASTER/0008", faculty);
//        Assert.isTrue(exists, "exists");
        return self();
    }
}
