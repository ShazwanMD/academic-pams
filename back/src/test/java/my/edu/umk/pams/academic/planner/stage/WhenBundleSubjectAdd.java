package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdAcademicPeriod;
import my.edu.umk.pams.academic.planner.model.AdBundleSubject;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPart;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPartImpl;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdSingleSubject;
import my.edu.umk.pams.academic.planner.model.AdSingleSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdSubjectType;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenBundleSubjectAdd extends Stage<WhenBundleSubjectAdd> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBundleSubjectAdd.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdCurriculum curriculum;

	@ProvidedScenarioState
	AdBundleSubject bundleSubject;

	@ExpectedScenarioState
	AdSingleSubject subject;

	@ProvidedScenarioState
	AdBundleSubjectPart part;

	public WhenBundleSubjectAdd add_bundle_subject_$(String COURSE_CODE) {

		// add bundle subject
		bundleSubject = new AdBundleSubjectImpl();
		bundleSubject.setSubjectType(AdSubjectType.ELECTIVE);
		bundleSubject.setPeriod(AdAcademicPeriod.II);

		plannerService.addSubject(curriculum, bundleSubject);

		// add bundle subject part
		AdBundleSubjectPart part1 = new AdBundleSubjectPartImpl();
		part1.setCourse(plannerService.findCourseByCode(COURSE_CODE));

		AdBundleSubjectPart part2 = new AdBundleSubjectPartImpl();
		part2.setCourse(plannerService.findCourseByCode("COURSE_CODE"));

		plannerService.addSubjectPart(bundleSubject, part1);
		plannerService.addSubjectPart(bundleSubject, part2);

		return self();
	}
}
