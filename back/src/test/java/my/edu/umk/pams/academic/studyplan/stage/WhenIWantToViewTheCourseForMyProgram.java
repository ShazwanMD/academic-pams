package my.edu.umk.pams.academic.studyplan.stage;

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
public class WhenIWantToViewTheCourseForMyProgram extends Stage<WhenIWantToViewTheCourseForMyProgram> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewTheCourseForMyProgram.class);

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

	public WhenIWantToViewTheCourseForMyProgram() {
		AdFaculty faculty = new AdFacultyImpl();
	}

	public WhenIWantToViewTheCourseForMyProgram I_Want_To_View_The_Course_$(String code) {

		faculty = studyplanService.findFacultyByCode(code);

		course = studyplanService.findCourses(faculty);

		for (AdCourse course : course) {
			LOG.debug(course.getTitle());
		}
		return self();
	}

}