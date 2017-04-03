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
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;

@JGivenStage
public class WhenIAppointStaffToSections extends Stage<WhenIAppointStaffToSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAppointStaffToSections.class);

	@Autowired
	private TermService termService;
	
	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdAppointment appointment;

	@ProvidedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public WhenIAppointStaffToSections I_appoint_staff_for_sections() {

		section = termService.findSectionByCanonicalCode("FKP/PHD/0001/DDA2113/201720181");
		staff = identityService.findStaffByStaffNo("01001A");

		appointment = new AdAppointmentImpl();
		appointment.setSection(section);
		appointment.setStaff(staff);
		appointment.setStatus(AdAppointmentStatus.NEW);
		
		termService.saveAppointment(appointment);

		return self();
	}
}
