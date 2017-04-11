package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheEnrollmentIsUpdated extends Stage<ThenTheEnrollmentIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheEnrollmentIsUpdated.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	public ThenTheEnrollmentIsUpdated the_enrollment_is_updated() {

		AdStudent student = identityService.findStudentByMatricNo("A17P001");
		AdSection section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");

		AdEnrollment enrollment = termService.findEnrollmentBySectionAndStudent(section, student);

		LOG.debug("New enrollment has been transfered: {} ", enrollment.getId());
		LOG.debug("New enrollment has been transfered: {} ", enrollment.getStanding());

		LOG.debug("Student info: {} ", student.getName());
		LOG.debug("Section info: {} ", section.getCanonicalCode());

		Assert.notNull(enrollment, "Enrollment data should be not null");

		return null;

	}
}
