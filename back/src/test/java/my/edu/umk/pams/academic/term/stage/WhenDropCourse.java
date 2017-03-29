package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenDropCourse extends Stage<WhenDropCourse> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenDropCourse.class);

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
    private CommonService commonService;
	
	@ExpectedScenarioState
	private AdCourse course;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	
	public WhenDropCourse I_want_to_drop_enrollment_course() {
		
		course = plannerService.findCourseByCode("DDA2062");
		faculty = plannerService.findFacultyByCode("21");
		plannerService.removeCourse(faculty, course);
		return self();	
	}

}
