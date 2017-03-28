/**
 * @author asyikin.mr
 */
package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

@JGivenStage
public class WhenIAppointStaffToSections extends Stage<WhenIAppointStaffToSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAppointStaffToSections.class);

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdAppointment appointment;

	@ProvidedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private String canonicalCode;

	@ProvidedScenarioState
	private AdMetadata metadata;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public WhenIAppointStaffToSections I_appoint_staff_for_sections() {

		LOG.debug("appointment: {}", appointment.getStaff());

		canonicalCode = faculty.getCode() + "/" + course.getCode() + "/" + academicSession.getCode();
		section = termService.findSectionByCanonicalCode(canonicalCode);

		appointment = new AdAppointmentImpl();
		appointment.setSection(section);
		appointment.setStaff(staff);
		appointment.setStatus(AdAppointmentStatus.NEW);
		appointment.setMetadata(metadata);

		termService.saveAppointment(appointment);

		return self();
	}
}
