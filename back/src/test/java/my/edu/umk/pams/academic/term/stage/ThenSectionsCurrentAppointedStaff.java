package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

public class ThenSectionsCurrentAppointedStaff extends Stage<ThenSectionsCurrentAppointedStaff> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenSectionsCurrentAppointedStaff.class);
	
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

	public ThenSectionsCurrentAppointedStaff  Section_current_appointed_staff_info() {
		
		LOG.debug("appointment {} ", appointment.getStatus());
		Assert.notNull(staff, "staff data value passed");
		Assert.notNull(section, "section data value passed ");
		Assert.notNull(appointment, "appointment data value passed");

		LOG.debug("staff: {}", staff.getId());
		LOG.debug("section: {}", section.getId());
		LOG.debug("appointment: {}", appointment.getId());
		
		return self();
	
		
	}


}
