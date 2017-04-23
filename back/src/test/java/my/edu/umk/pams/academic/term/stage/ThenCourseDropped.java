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
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationAction;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenCourseDropped extends Stage<ThenCourseDropped> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenCourseDropped.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	public ThenCourseDropped The_course_enrollment_are_dropped() {

		List<AdEnrollmentApplication> applications = termService.findEnrollmentApplications("", academicSession,
				student, 0, 10);
		for (AdEnrollmentApplication application : applications) {
			LOG.debug("======updated info======");
			LOG.debug("AdEnrollmentApplication: {}", application.getId());

			List<AdEnrollmentApplicationItem> items = termService.findEnrollmentApplicationItems(application);

			for (AdEnrollmentApplicationItem item : items) {
				LOG.debug("AdEnrollmentApplicationItem: {}", item.getId());
				LOG.debug("Updated status: {}", item.getAction());

			}
		}

		return self();

	}

}
