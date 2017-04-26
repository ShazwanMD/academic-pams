package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdBundleSubject;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPart;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPartImpl;
import my.edu.umk.pams.academic.planner.model.AdSingleSubject;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenSubjectAdded extends Stage<ThenSubjectAdded> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenSubjectAdded.class);
	
	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	AdBundleSubject bundleSubject;

	@ExpectedScenarioState
	AdSingleSubject singleSubject;


	public ThenSubjectAdded subject_added() {

		Assert.notNull(bundleSubject, "bundleSubject cannot be null");
		Assert.notNull(singleSubject, "singleSubject cannot be null");
		
		AdBundleSubjectPart part1 = new AdBundleSubjectPartImpl();
		part1.setCourse(plannerService.findCourseByCode("GST5013"));
		Assert.notNull(part1, "bundle part 1 cannot be null");
		LOG.debug("bundle1 : {}", part1.getCourse().getCode() );

		AdBundleSubjectPart part2 = new AdBundleSubjectPartImpl();
		part2.setCourse(plannerService.findCourseByCode("GST5023"));
		Assert.notNull(part2, "bundle part 2 cannot be null");
		LOG.debug("bundle2 : {}", part2.getCourse().getCode() );

		return self();
	}

}
