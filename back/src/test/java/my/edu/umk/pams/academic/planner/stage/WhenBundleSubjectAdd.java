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
import org.springframework.util.Assert;

@JGivenStage
public class WhenBundleSubjectAdd extends Stage<WhenBundleSubjectAdd> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenBundleSubjectAdd.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	@ProvidedScenarioState
	AdBundleSubject bundleSubject;

	@ProvidedScenarioState
	AdSingleSubject singleSubject;

	@ProvidedScenarioState
	AdBundleSubjectPart part;

	@ExpectedScenarioState
	private String courseCode;

	public WhenBundleSubjectAdd add_bundle_subject() {
		
		bundleSubject = new AdBundleSubjectImpl();
		bundleSubject.setSubjectType(AdSubjectType.ELECTIVE);
		bundleSubject.setPeriod(AdAcademicPeriod.II);
		plannerService.addSubject(curriculum, bundleSubject);

		return self();
	}

	public WhenBundleSubjectAdd add_bundle_subject_part() {

		AdBundleSubjectPart part1 = new AdBundleSubjectPartImpl();
		part1.setCourse(plannerService.findCourseByCode(courseCode));

		AdBundleSubjectPart part2 = new AdBundleSubjectPartImpl();
		part2.setCourse(plannerService.findCourseByCode(courseCode));

		plannerService.addSubjectPart(bundleSubject, part1);
		plannerService.addSubjectPart(bundleSubject, part2);

		return self();

	}

	public WhenBundleSubjectAdd add_single_subject() {
        AdCourse course = plannerService.findCourseByCode(courseCode);
        Assert.notNull(course, "course cannot be null");

		singleSubject = new AdSingleSubjectImpl();
		singleSubject.setCourse(course);
		singleSubject.setPeriod(AdAcademicPeriod.I);
		singleSubject.setSubjectType(AdSubjectType.CORE);

		plannerService.addSubject(curriculum, singleSubject);

		return self();

	}

}
