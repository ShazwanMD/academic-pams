package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdBundleSubject;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPart;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPartImpl;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenSetupBundleSubjectPart extends Stage<WhenSetupBundleSubjectPart> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAddProgramLevel.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdBundleSubject bundle;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private List<AdBundleSubjectPart> parts;

	public WhenSetupBundleSubjectPart I_setup_bundle_subject_part_for_course_$(String cOURSE_CODE,
			String fACULTY_CODE) {

		faculty = plannerService.findFacultyByCode(fACULTY_CODE);
		LOG.debug("faculty code:{}", faculty.getCode());

		course = plannerService.findCourseByCodeAndFaculty(cOURSE_CODE, faculty);
		LOG.debug("course code:{}", course.getCode());

		LOG.debug(faculty.getCode());

		AdBundleSubjectPart part = new AdBundleSubjectPartImpl();

		part.setBundle(bundle);

		part.setCourse(course);

		AdBundleSubject bundle = new AdBundleSubjectImpl();

		bundle.setParts(parts);

		// List<AdBundleSubjectPart> parts = plannerService.findCourseByCode();

		return self();
	}
}
