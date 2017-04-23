package my.edu.umk.pams.academic.planner.stage;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * @author zaida
 */
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateCredit extends Stage<WhenAdminUpdateCredit>{

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateCredit.class);
			
	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdFaculty faculty;	
	
	@ProvidedScenarioState
	private AdCourse course;
	

	
	public WhenAdminUpdateCredit Admin_update_credit() {
		

		course = plannerService.findCourseByCode("GST5013");
		Assert.notNull(course, "course cannot be null");
		course.setCredit(4);
		plannerService.updateCourse(faculty, course);
		
		
		return self();
		
		
		
}
}