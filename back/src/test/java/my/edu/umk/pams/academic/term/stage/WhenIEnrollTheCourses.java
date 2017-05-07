package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class WhenIEnrollTheCourses extends Stage<WhenIEnrollTheCourses> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIEnrollTheCourses.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdStudent student;

	private String canonicalCode;

	public WhenIEnrollTheCourses I_enroll_the_courses_for_program_$(String code) {

		canonicalCode = "FIAT-MASTER-PBH-GST5023-201720181";
		String StudentNo = "A17P001"; 
		section = termService.findSectionByCanonicalCode(canonicalCode);
		student = identityService.findStudentByMatricNo(StudentNo);

		enrollment = new AdEnrollmentImpl();
		enrollment.setSection(section);
		enrollment.setStudent(student);
		enrollment.setStatus(AdEnrollmentStatus.NEW);
		termService.saveEnrollment(enrollment);

		return self();

	}
}
