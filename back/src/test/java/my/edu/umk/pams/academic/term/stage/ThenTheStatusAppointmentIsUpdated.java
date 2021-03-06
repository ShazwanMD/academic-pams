/**
 * @author asyikin.mr 
*/
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

@JGivenStage
public class ThenTheStatusAppointmentIsUpdated extends Stage<ThenTheStatusAppointmentIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheStatusAppointmentIsUpdated.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdAppointment appointment;

	@ExpectedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdSection section;

	public ThenTheStatusAppointmentIsUpdated the_appointment_status_is_updated() {

		AdAppointment appointment = termService.findAppointmentBySectionAndStaff(section, staff);
		LOG.debug("appointment status {} ", appointment.getStatus());
		Assert.notNull(appointment, "The data must not be null");

		return self();
	}
}
