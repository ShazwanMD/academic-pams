package my.edu.umk.pams.academic.profile.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;


@JGivenStage
public class WhenIViewCourseRegistration extends Stage<WhenIViewCourseRegistration> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewCourseRegistration.class);
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ProvidedScenarioState
	private	AdStudent student;
	
	@ProvidedScenarioState
	private List<AdCourse> course;
	
	private AdFaculty faculty;
	
	private String code;
	
	public WhenIViewCourseRegistration I_view_student_course_registration() {
		//student = identityService.findStudentByStudentNo("A17P002");
		
		faculty = plannerService.findFacultyByCode("FKP");
		course = plannerService.findCourses(faculty);

		for (AdCourse course : course) {
			LOG.debug(course.getTitle());
		}
		
		
		return self();
	}

	@Pending
	public WhenIViewCourseRegistration I_view_student_payment_status() {
		

		return self();
	}

}
