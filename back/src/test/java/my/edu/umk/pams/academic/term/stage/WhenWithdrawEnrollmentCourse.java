package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationAction;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenWithdrawEnrollmentCourse extends Stage<WhenWithdrawEnrollmentCourse> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenWithdrawEnrollmentCourse.class);

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;
	
	@ProvidedScenarioState
	private List<AdEnrollmentApplicationItem> items;
	
	@Pending
	public WhenWithdrawEnrollmentCourse I_withdraw_enrollment_course() {

		String referenceNo = "201720181/001";
		application = termService.findEnrollmentApplicationByReferenceNo(referenceNo);
		section = termService.findSectionByCanonicalCode("FIAT/MASTER/PBH/GST5023/201720181");

		List<AdEnrollmentApplicationItem> items = termService.findEnrollmentApplicationItems(application);

		for (AdEnrollmentApplicationItem item : items) {
			LOG.debug("Action of application:" + item.getAction());

			item.setAction(AdEnrollmentApplicationAction.DROP);
			item.setSection(section);

			termService.updateEnrollmentApplication(application);

			LOG.debug("New action of application:" + item.getAction());
			Assert.notNull(item, "Item data should be not null");

		}

		return self();

	}
}
