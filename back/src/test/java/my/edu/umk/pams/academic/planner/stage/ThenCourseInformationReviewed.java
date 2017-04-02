package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenCourseInformationReviewed extends Stage<ThenCourseInformationReviewed> {

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    AdCourse course;

    @ExpectedScenarioState
    AdFaculty faculty;

    @Pending
    public ThenCourseInformationReviewed course_information_reviewed() {
//	        List<AdCourse> Course = plannerService.findCourses(faculty);
//	        Assert.notEmpty(Course, "Course should not be empty");
        return self();
    }

		
	}