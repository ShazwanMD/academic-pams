package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
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
	AdEnrollmentApplicationItem item;

	@ExpectedScenarioState
	private AdEnrollmentApplication application;

	@ExpectedScenarioState
	private AdSection section;

	public ThenICanViewTheWithdrawnCourse i_can_view_the_withdrawn_course() {

		String referenceNo = "201720181/006";
		application = termService.findEnrollmentApplicationByReferenceNo(referenceNo);
		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");

		List<AdEnrollmentApplicationItem> items = termService.findEnrollmentApplicationItems(application);
		
		for (AdEnrollmentApplicationItem item : items) {
		Assert.notNull(item, "Item data should be not null");

		LOG.debug("Enrollment application for application:" + application.getReferenceNo());
		LOG.debug("Enrollment application under section:" + section.getCanonicalCode());
		LOG.debug("New action for enrollment application has been updated:" + item.getAction());
		}
		return self();
	}
	
}
