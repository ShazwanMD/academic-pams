package my.edu.umk.pams.academic.term.stage;

/* @author asyikin.mr and ziana
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIWantToEnrollAdditionalOfferingCoursesToRepeatCourses
		extends Stage<WhenIWantToEnrollAdditionalOfferingCoursesToRepeatCourses> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToEnrollAdditionalOfferingCoursesToRepeatCourses.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ProvidedScenarioState
	private AdAdmission admission;

	@ExpectedScenarioState
	private AdStudent student;

	public WhenIWantToEnrollAdditionalOfferingCoursesToRepeatCourses I_want_to_enroll_additional_offering_courses_to_repeat_courses_for_program_$(
			String code) {

		section = termService.findSectionByCanonicalCode("FIAT-MASTER-PBH-GST5023-201720181");
		LOG.debug("A section{}", section);

		student = identityService.findStudentByMatricNo("A17P002");
		LOG.debug("B student{}", student);

		enrollment = new AdEnrollmentImpl();
		enrollment.setSection(section);
		enrollment.setStatus(AdEnrollmentStatus.NEW);
		enrollment.setStanding(AdEnrollmentStanding.UG);
		termService.saveEnrollment(enrollment);

		return self();

	}
}
