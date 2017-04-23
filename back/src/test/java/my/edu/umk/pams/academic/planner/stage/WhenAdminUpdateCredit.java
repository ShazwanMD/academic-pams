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

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCourseImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateCredit extends Stage<WhenAdminUpdateCredit>{

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateCredit.class);
	
	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;
	
	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
    private AdCourse course;
	
	
	public WhenAdminUpdateCredit Admin_update_credit_hour_for_$(String courseCode) {
		
//		List<AdCourse> courses = plannerService.findCourses(faculty);
//		courses.forEach(course -> {
//			course.setCredit(credit);
//			plannerService.updateCourse(faculty, course);
//		});
//
//
//		List<AdCourse> courses = plannerService.findCourses(faculty);
//	
//			for (AdCourse course : courses) {
//	            LOG.debug(course.getCode());
//	        }
					
//        faculty = plannerService.findFacultyByCode(code);
//
//        AdCourse courses = new AdCourseImpl();
//
//        courses.setCode("DDA1155");
//        courses.setFaculty(faculty);
//        courses.setClassification(AdAcademicClassification.LEVEL_000);
//        courses.setTitle("LUKISAN SAM");
//        courses.setTitleEn("ENGINEERING SAM");
//        courses.setTitleMs("LUKISAN SAM");
//
//        plannerService.addCourse(faculty, courses);
        
		
		
		course = plannerService.findCourseByCode(courseCode);
			course.setCredit(5);
			LOG.debug("");
//			LOG.debug("xxxxxxxx", course.getCode());
//			LOG.debug("ss", course.getCredit());
			LOG.debug("Course Taken : {}", course.getCode());
			LOG.debug("Course Taken : {}", course.getCredit());

			
//	        courses.setCode("DDA1155");
//	        courses.setFaculty(faculty);
//	        courses.setClassification(AdAcademicClassification.LEVEL_000);
//	        courses.setTitle("LUKISAN SAM");
//	        courses.setTitleEn("ENGINEERING SAM");
//	        courses.setTitleMs("LUKISAN SAM");
		return self();
		
		
		
}
}