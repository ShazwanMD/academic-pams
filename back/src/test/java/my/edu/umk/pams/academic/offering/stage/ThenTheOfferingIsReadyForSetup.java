package my.edu.umk.pams.academic.offering.stage;

import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

/**
 * @author asyikin.mr and ziana
 */
@JGivenStage
public class ThenTheOfferingIsReadyForSetup extends Stage<ThenTheOfferingIsReadyForSetup> {

	@Autowired
	private OfferingService offeringService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdCourse course;

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheOfferingIsReadyForSetup.class);

	public ThenTheOfferingIsReadyForSetup the_course_is_ready_for_setup() {
		LOG.debug("course {} ", course);
		AdOffering offering = offeringService.findOfferingByProgramAndCourse(program, course);
		Assert.notNull(offering, "The data must not be null");
		return self();

	}
}
