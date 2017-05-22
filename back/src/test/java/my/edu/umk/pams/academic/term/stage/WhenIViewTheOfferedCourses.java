package my.edu.umk.pams.academic.term.stage;

/**
 * @author asyikin.mr and ziana
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIViewTheOfferedCourses extends Stage<WhenIViewTheOfferedCourses> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewTheOfferedCourses.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private List<AdOffering> offerings;

	@ExpectedScenarioState
	private String code;

	public WhenIViewTheOfferedCourses() {
		AdOffering offering = new AdOfferingImpl();
	}

	public WhenIViewTheOfferedCourses I_view_the_offered_courses_for_program_$(String code) {
		program = plannerService.findProgramByCode(code);
		offerings = termService.findOfferings(program);

		for (AdOffering offering : offerings) {
			
			LOG.debug("===========view offered course============");
			LOG.debug("offering Code: {}",offering.getCode());
			LOG.debug("offering Title: {}",offering.getTitleMs());
			LOG.debug("offering Code: {}",offering.getCapacity());
		}

		
		return self();
	}
}
