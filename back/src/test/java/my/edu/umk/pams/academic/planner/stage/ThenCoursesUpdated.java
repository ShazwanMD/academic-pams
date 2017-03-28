package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */

@JGivenStage
public class ThenCoursesUpdated extends Stage<ThenCoursesUpdated> {

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdCourse course;

    
    public ThenCoursesUpdated new_courses_information_updated() {

    	
    	boolean exists = plannerService.isCourseExists("DDA2113", faculty);
    	 Assert.isTrue(exists, "exists");
    	
        return self();

    }

}
