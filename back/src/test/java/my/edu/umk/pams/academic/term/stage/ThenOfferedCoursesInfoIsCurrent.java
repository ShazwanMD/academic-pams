package my.edu.umk.pams.academic.term.stage;

/**
 * @author asyikin.mr and ziana
 */
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdProgram;

@JGivenStage
public class ThenOfferedCoursesInfoIsCurrent extends Stage<ThenOfferedCoursesInfoIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenOfferedCoursesInfoIsCurrent.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private List<AdOffering> offerings;

	@ExpectedScenarioState
	private AdProgram program;

	public ThenOfferedCoursesInfoIsCurrent the_offered_courses_info_is_current() {

		
		Assert.notNull(offerings, "Data offerings not null");
		for (AdOffering offering : offerings) {
			
			LOG.debug("=========offered course is current==========");
			LOG.debug("Offering Id:{}",offering.getId());
			LOG.debug("Offering Code:{}",offering.getCode());
			LOG.debug("Offering CanonicalCode:{}",offering.getCanonicalCode());
			LOG.debug("Offering Capacity:{}",offering.getCapacity());
			LOG.debug("Offering Title:{}",offering.getTitle());
			LOG.debug("Offering Program:{}",offering.getProgram().getTitle());
			LOG.debug("Offering Course:{}",offering.getCourse().getTitle());
		}

		return self();
	}
}