/**
 * @author asyikin.mr
 */
package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIWantToUpdateAppointmentStatus extends Stage<WhenIWantToUpdateAppointmentStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToUpdateAppointmentStatus.class);

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

	public WhenIWantToUpdateAppointmentStatus I_update_appointment_status() {

		section = termService.findSectionByCanonicalCode("FKP/PHD/0001/DDA2022/201720181");
		staff = identityService.findStaffByStaffNo("01002A");
		appointment = termService.findAppointmentBySectionAndStaff(section, staff);

		LOG.debug("section {} ", section.getCanonicalCode());
		LOG.debug("staff {} ", staff.getIdentityNo());
		LOG.debug("appointment {} ", appointment.getId());

		appointment.setStatus(AdAppointmentStatus.CONFIRMED);
		termService.updateAppointment(appointment);

		return self();

	}
}