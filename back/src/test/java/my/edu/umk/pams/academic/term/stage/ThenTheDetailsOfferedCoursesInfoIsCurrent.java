package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;

@JGivenStage
public class ThenTheDetailsOfferedCoursesInfoIsCurrent extends Stage<ThenTheDetailsOfferedCoursesInfoIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheDetailsOfferedCoursesInfoIsCurrent.class);

	@ExpectedScenarioState
	private AdOffering offering;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private List<AdOffering> offerings;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public ThenTheDetailsOfferedCoursesInfoIsCurrent the_details_offered_courses_info_is_current() {

		Assert.notEmpty(offerings, "the offerings for this program is not empty");

		for (AdOffering offering : offerings) {

			LOG.debug("==================offered course is current===================");
			LOG.debug("title for this program: {}", offering.getProgram().getTitle());
			LOG.debug("courses for this program : {}", offering.getCourse().getTitleEn());
			LOG.debug("courses for this program : {}", offering.getCourse().getTitleMs());
			LOG.debug("credit for this course : {}", offering.getCourse().getCredit());
			LOG.debug("");

		}
		return self();
	}
}