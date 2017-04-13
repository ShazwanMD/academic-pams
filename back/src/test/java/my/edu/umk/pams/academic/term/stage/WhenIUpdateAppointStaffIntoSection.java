package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIUpdateAppointStaffIntoSection extends Stage<WhenIUpdateAppointStaffIntoSection> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAppointStaffIntoSection.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdAppointment appointment;

	@ProvidedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdAppointmentStatus status;

	public WhenIUpdateAppointStaffIntoSection I_update_appoint_staff_into_section() {

		Assert.notNull(section, "section should be not null");
		LOG.debug("section: {}", section.getCanonicalCode());
		
		staff = identityService.findStaffByStaffNo("01001A"); //cari staff dri db
		LOG.debug("staff: {}", staff.getId());
		

		appointment = termService.findAppointmentBySectionAndStaff(section, staff);
		
		Assert.notNull(appointment, "appointment should be not null");
		LOG.debug("appointment: {}", appointment.getId());
		LOG.debug("staff: {}", appointment.getStaff().getName()); //view staf yang sedia ada
		
		
		staff = identityService.findStaffByStaffNo("01002A"); // cari staf baru
		
		appointment.setStaff(staff);
		termService.updateAppointment(appointment);
		
		Assert.notNull(appointment, "appointment should be not null");
		LOG.debug("appointment staff: {}", appointment.getStaff().getName());
		
		return self();

	}

}
