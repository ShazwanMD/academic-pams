package my.edu.umk.pams.academic.term.stage;

import org.springframework.beans.factory.annotation.Autowired;

//todo asyikin
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenCourseDropped extends Stage<ThenCourseDropped> {
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
    private CommonService commonService;
	
	@ProvidedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	private AdFaculty faculty;
	
	public ThenCourseDropped  The_course_enrollment_are_dropped() {
		//tolong semak ye
		plannerService.findCourseByCodeAndFaculty("DDA2113", faculty);
		plannerService.removeCourse(faculty, course);
		 
		return self();	
		
	}

}

