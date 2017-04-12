package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@Pending
@JGivenStage
public class WhenWantToViewOpenDateOfEnrollment extends Stage<WhenWantToViewOpenDateOfEnrollment> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenWantToViewOpenDateOfEnrollment.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	public WhenWantToViewOpenDateOfEnrollment Want_to_view_open_date_of_enrollment() {

		// process to view open date in ad_cnfg table
		

		return self();
	}
}
