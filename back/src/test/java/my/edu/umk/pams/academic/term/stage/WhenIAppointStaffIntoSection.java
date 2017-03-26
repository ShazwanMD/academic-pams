package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class WhenIAppointStaffIntoSection extends Stage<WhenIAppointStaffIntoSection> {
    private static final Logger LOG = LoggerFactory.getLogger(WhenIAppointStaffIntoSection.class);

    @Autowired
    private TermService termService;

    @Autowired
    private IdentityService identityService;

    @ProvidedScenarioState
    private AdAppointment appointment;

    @ExpectedScenarioState
    private AdStaff staff;

    @ExpectedScenarioState
    private AdSection section;

    public WhenIAppointStaffIntoSection I_appoint_a_staff_$_into_section(String staffNo) {
        LOG.debug("appointment into section: {}", section.getCanonicalCode());
        staff = identityService.findStaffByStaffNo(staffNo);

        // add appointment of staff to section
        appointment = new AdAppointmentImpl();
        appointment.setStatus(AdAppointmentStatus.CONFIRMED);
        appointment.setStaff(staff);
        appointment.setSection(section);
        termService.saveAppointment(appointment);

        return self();
    }
}
