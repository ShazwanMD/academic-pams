package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import java.util.List;

@JGivenStage
public class WhenITransferSection extends Stage<WhenITransferSection> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenITransferSection.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdAcademicSession session;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;

	@ProvidedScenarioState
	private AdAdmission admission;

	@ProvidedScenarioState
	private AdGradeCode gradeCode;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	public WhenITransferSection I_transfer_section() {

		List<AdEnrollmentApplication> applications = termService.findEnrollmentApplications(session);

		for (AdEnrollmentApplication application : applications) {

			LOG.debug("Student Enrollment application id: {}", application.getId());

			List<AdEnrollmentApplicationItem> items = termService.findEnrollmentApplicationItems(application);

			for (AdEnrollmentApplicationItem item : items) {

				LOG.debug("Item id: {}", item.getId());

				AdEnrollment enrollment = new AdEnrollmentImpl();
				enrollment.setStanding(AdEnrollmentStanding.HW);
				enrollment.setStudent(application.getStudent());
				enrollment.setSection(item.getSection());
				enrollment.setStatus(AdEnrollmentStatus.NEW);
				enrollment.setGradeCode(gradeCode);
				enrollment.setAdmission(admission);

				termService.saveEnrollment(enrollment);

				LOG.debug("New enrollment inserted id: {}", enrollment.getId());
				Assert.notNull(enrollment, "Enrollment data should be not null");

			}

		}

		return self();
	}

}
