package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenICanViewTheWithdrawnCourse extends Stage<ThenICanViewTheWithdrawnCourse> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenICanViewTheWithdrawnCourse.class);

	@Autowired
	private TermService termService;
	
	@ExpectedScenarioState
	private AdEnrollmentApplicationItem item;

	@ExpectedScenarioState
	private AdEnrollmentApplication application;

	@ExpectedScenarioState
	private AdSection section;
	
	@ExpectedScenarioState
	private List<AdEnrollmentApplicationItem> items;
	
	@Pending
	public ThenICanViewTheWithdrawnCourse i_can_view_the_withdrawn_course() {

		LOG.debug("======================view data=========================");
		LOG.debug("Enrollment application for application:" + application.getReferenceNo());
		LOG.debug("Enrollment application under section:" + section.getCanonicalCode());
		LOG.debug("New action for enrollment application has been updated:" + item.getAction());
		
		return self();
	}
	
}
