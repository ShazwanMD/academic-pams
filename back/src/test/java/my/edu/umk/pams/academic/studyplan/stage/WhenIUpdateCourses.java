package my.edu.umk.pams.academic.studyplan.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.profile.stage.WhenIUpdateMyBillingAddress;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicClassification;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdCourseImpl;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

/**
 * @author PAMS - Rodziah Mohamad Nor
 */
@JGivenStage
public class WhenIUpdateCourses extends Stage<WhenIUpdateCourses> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateCourses.class);

	@Autowired
	private StudyplanService studyplanService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	public WhenIUpdateCourses I_update_courses_to_faculty_code_$a(String code) {

		return self();
	}
}