package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

	public WhenBundleSubjectAdd add_bundle_subject() {

		// add bundle subject
		bundleSubject = new AdBundleSubjectImpl();
		bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
		bundleSubject.setCurriculum(curriculum);
		bundleSubject.setOrdinal(2);

		plannerService.addSubject(curriculum, bundleSubject);
		LOG.debug("bundle subject : {}", bundleSubject.getCurriculum().getCode());

		// add bundle subject part
		AdBundleSubjectPart part1 = new AdBundleSubjectPartImpl();
		part1.setCourse(plannerService.findCourseByCode("GST5021"));
		part1.setCourse(plannerService.findCourseByCode("GST5023"));
		part1.setCourse(plannerService.findCourseByCode("GST5063"));
		part1.setCourse(plannerService.findCourseByCode("GST5043"));
		part1.setCourse(plannerService.findCourseByCode("GST5053"));

		AdBundleSubjectPart part2 = new AdBundleSubjectPartImpl();
		part2.setCourse(plannerService.findCourseByCode("GST5033"));
		part2.setCourse(plannerService.findCourseByCode("GST5073"));
		part2.setCourse(plannerService.findCourseByCode("GST5083"));
		part2.setCourse(plannerService.findCourseByCode("GST5113"));
		part2.setCourse(plannerService.findCourseByCode("GST5103"));
		
		
		AdBundleSubjectPart part3 = new AdBundleSubjectPartImpl();
		part3.setCourse(plannerService.findCourseByCode("GST5093"));
		part3.setCourse(plannerService.findCourseByCode("GST5123"));
		
		plannerService.addSubjectPart(bundleSubject, part1);
		plannerService.addSubjectPart(bundleSubject, part2);
		plannerService.addSubjectPart(bundleSubject, part3);
		
		
		LOG.debug("bundle1 subject : {}", part1.getCourse().getCode() );
		LOG.debug("bundle1 subject : {}", part1.getCourse().getCode() );
		LOG.debug("bundle1 subject : {}", part1.getCourse().getCode() );
		LOG.debug("bundle1 subject : {}", part1.getCourse().getCode() );
		LOG.debug("bundle1 subject : {}", part1.getCourse().getCode() );
		
		LOG.debug("bundle2 subject : {}", part2.getCourse().getCode() );
		
		
		return self();
	}
}
