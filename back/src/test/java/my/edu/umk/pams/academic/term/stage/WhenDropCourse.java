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
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationAction;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItemImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenDropCourse extends Stage<WhenDropCourse> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenDropCourse.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@Pending
	public WhenDropCourse I_want_to_drop_enrollment_course() {

		student = (AdStudent) identityService.findActorByIdentityNo("A17P001");
		section = termService.findSectionByCanonicalCode("FIAT/MASTER/PBH/GST5023/201720181");
		LOG.debug("Section Code: {}", section.getCode());
		LOG.debug("Student Code: {}", student.getIdentityNo());

		List<AdEnrollmentApplication> applications = termService.findEnrollmentApplications("%20172018%",
				academicSession, student, 0, 10);

		for (AdEnrollmentApplication application : applications) {
			LOG.debug("AdEnrollmentApplication: {}", application.getId());
			
			AdEnrollmentApplicationItem item = termService.findEnrollmentApplicationItemBySection(section);

			LOG.debug("AdEnrollmentApplicationItem: {}", item.getId());
			LOG.debug("AdEnrollmentApplicationItem: {}", item.getAction());
			LOG.debug("AdEnrollmentApplicationItem: {}", item.getSection().getCanonicalCode());
			
			item.setAction(AdEnrollmentApplicationAction.DROP);
			item.setApplication(application);
			item.setSection(section);
			termService.updateEnrollmentApplicationItem(application, item);

			LOG.debug("updated to DROP status: {}", item.getAction());

		}

		return self();
	}

}
