package my.edu.umk.pams.academic.offering.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.offering.model.AdAppointment;
import my.edu.umk.pams.academic.offering.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAppointmentStatus;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class WhenIUpdateAppointmentStatus extends Stage<WhenIUpdateAppointmentStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAppointmentStatus.class);

	@Autowired
	private OfferingService offeringService;
	
	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdAppointment appointment;
	
	@ProvidedScenarioState
	private AdStaff staff;
	
	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdMetadata metadata;
	
	private String StaffNo = "01612B";
	private String canonicalCode = "SEC01";
	
		public WhenIUpdateAppointmentStatus I_update_appointment_status_under_program_faculty() {

		LOG.debug("appointment: {}", appointment.getStatus());
        staff =   identityService.findStaffByStaffNo(StaffNo);
        section = offeringService.findSectionByCanonicalCode(canonicalCode);
		
        appointment = new AdAppointmentImpl();
		appointment.setStatus(AdAppointmentStatus.CONFIRMED);
		appointment.setStaff(staff);
		appointment.setSection(section);
		appointment.setMetadata(metadata);

		offeringService.updateAppointment(appointment);

		return self();

	}
}
