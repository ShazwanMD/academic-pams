package my.edu.umk.pams.academic.studyplan.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class ThenICanPlanWhatToManageScheduleDetail extends Stage<ThenICanPlanWhatToManageScheduleDetail>{
	
	 @Autowired
	    private StudyplanService studyplanService;

	    @ExpectedScenarioState
	    AdCourse course;
	    
	    @ExpectedScenarioState
	    AdFaculty faculty;


	    public ThenICanPlanWhatToManageScheduleDetail I_Can_Plan_What_To_Manage_Schedule_Detail() {
//	        List<AdCourse> Course = studyplanService.findCourses(faculty);
//	        Assert.notEmpty(Course, "Course should not be empty");
	        return self();
	    }
}