package my.edu.umk.pams.academic.offering.stage;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.offering.model.AdAppointment;
import my.edu.umk.pams.academic.offering.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class WhenIAppointStaffToSections extends Stage<WhenIAppointStaffToSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAppointStaffToSections.class);

	@Autowired
	private OfferingService offeringService;

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
		section = offeringService.findSectionByCanonicalCode(canonicalCode);

		appointment = new AdAppointmentImpl();
		appointment.setSection(section);
		appointment.setStaff(staff);
		appointment.setStatus(AdAppointmentStatus.NEW);
		appointment.setMetadata(metadata);
		
		offeringService.saveAppointment(appointment);

		return self();
	}
}
