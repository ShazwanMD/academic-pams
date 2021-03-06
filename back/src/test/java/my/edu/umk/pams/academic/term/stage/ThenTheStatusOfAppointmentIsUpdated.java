package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class ThenTheStatusOfAppointmentIsUpdated extends Stage<ThenTheStatusOfAppointmentIsUpdated> {
    private static final Logger LOG = LoggerFactory.getLogger(ThenTheStatusOfAppointmentIsUpdated.class);

    @Autowired
    private TermService termService;

    @ExpectedScenarioState
    private AdAppointment appointment;

    @ExpectedScenarioState
    private AdSection section;

    @ExpectedScenarioState
    private AdStaff staff;

    public ThenTheStatusOfAppointmentIsUpdated the_number_of_appointed_staff_increased() {
        LOG.debug("appointment {} ", appointment.getStatus());
        Integer count = termService.countAppointment(section);
        Assert.isTrue(count > 0, "Appointment is bigger than zero");
        return self();
    }
}
