package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class ThenInformationUpdated extends Stage<ThenInformationUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenInformationUpdated.class);

	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	AdFaculty faculty;

	public ThenInformationUpdated Information_updated() {

		List<AdCourse> courses = studyplanService.findCourses(faculty);
		Assert.assertTrue(!(courses.isEmpty()));
		return self();
	}

}
