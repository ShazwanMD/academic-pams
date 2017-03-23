package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAppointmentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    private String canonicalCode = "SEC01";

    public WhenIUpdateAppointmentStatus I_appoint_a_staff_$_into_all_section_for_the_offering(String staffNo) {
        LOG.debug("appointment: {}", appointment.getStatus());
        staff = identityService.findStaffByStaffNo(staffNo);
        section = offeringService.findSectionByCanonicalCode(canonicalCode);

        appointment = new AdAppointmentImpl();
        appointment.setStatus(AdAppointmentStatus.CONFIRMED);
        appointment.setStaff(staff);
        appointment.setSection(section);
        offeringService.updateAppointment(appointment);

        return self();
    }
}
