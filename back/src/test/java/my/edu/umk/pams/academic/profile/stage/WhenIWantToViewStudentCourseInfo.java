package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdFacultyImpl;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIWantToViewStudentCourseInfo extends Stage<WhenIWantToViewStudentCourseInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewCourseInfo.class);

	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private List<AdCourse> course;
	
	@ExpectedScenarioState
	private String code;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	public WhenIWantToViewStudentCourseInfo(){
		AdFaculty faculty = new AdFacultyImpl();
	}
	
	public WhenIWantToViewStudentCourseInfo I_view_student_course_info_for_faculty_$(String code) {
		faculty = studyplanService.findFacultyByCode(code);
		
		course = studyplanService.findCourses(faculty);

		for (AdCourse course : course) {
			LOG.debug(course.getTitle());
		}
		return self();
	}
}
