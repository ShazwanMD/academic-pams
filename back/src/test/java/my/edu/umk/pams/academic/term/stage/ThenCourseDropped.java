package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenCourseDropped extends Stage<ThenCourseDropped> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenCourseDropped.class);

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdSection section;

	public ThenCourseDropped() {
		AdEnrollment enrollment = new AdEnrollmentImpl();
	}

	public ThenCourseDropped The_course_enrollment_are_dropped() {

		enrollment = termService.findEnrollmentBySectionAndStudent(section, student);

		LOG.debug("Deleted:" + enrollment.getSection());

		return self();

	}

}
