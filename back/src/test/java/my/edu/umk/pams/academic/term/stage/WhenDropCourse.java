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
import my.edu.umk.pams.academic.identity.model.AdStudent;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationAction;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationType;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenDropCourse extends Stage<WhenDropCourse> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenDropCourse.class);

	@Autowired
	private TermService termService;

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

	@ProvidedScenarioState
	private List<AdEnrollmentApplication> applications;
	
	@ProvidedScenarioState
	private String canonicalCode = "MGSEB-MBA-GST5023-201720181";

	public WhenDropCourse I_want_to_drop_enrollment_course() {

		applications = termService.findEnrollmentApplications("des", academicSession, student, 0, 100);
		Assert.notEmpty(applications, "applications are empty");

		for (AdEnrollmentApplication application : applications) {
			LOG.debug("Application Id:{}", application.getId());
			LOG.debug("Application Student:{}", application.getStudent().getId());

			section = termService.findSectionByCanonicalCode(canonicalCode);
			Assert.notNull(section, "Section data should be not null");
			LOG.debug("Section Code: {}", section.getCode());
			LOG.debug("Section Code: {}", section.getId());

			
			application.setAuditNo("www");
			application.setCancelComment("gggg");
			application.setDescription("New students enrollment ww");
			application.setRemoveComment("wwwww");
			application.setSourceNo("setSourceNo");
			application.setType(AdEnrollmentApplicationType.WAJIB);
			application.setSession(academicSession);
			application.setStudent(student);
			
			termService.startEnrollmentApplicationTask(application);

			String generatedReferenceNo = termService.startEnrollmentApplicationTask(application);
			application = termService.findEnrollmentApplicationByReferenceNo(generatedReferenceNo);
			Assert.notNull(application, "application data is null");
			
			AdEnrollmentApplicationItem item = termService.findEnrollmentApplicationItemBySection(section);
			Assert.notNull(item, "Item should be not null"); 
			LOG.debug("Previous action: {}", item.getAction());
			
			item.setAction(AdEnrollmentApplicationAction.DROP);
			item.setApplication(application);
			item.setSection(section);
			termService.updateEnrollmentApplicationItem(application, item);

			LOG.debug("========successfully updated=======");
			LOG.debug("Item Id: {}", item.getId());
			LOG.debug("Item referenceNo: {}", item.getApplication().getReferenceNo());
			LOG.debug("Item section: {}", item.getSection().getCanonicalCode());
			LOG.debug("Item new action: {}", item.getAction());
		}

		return self();
	}

}
