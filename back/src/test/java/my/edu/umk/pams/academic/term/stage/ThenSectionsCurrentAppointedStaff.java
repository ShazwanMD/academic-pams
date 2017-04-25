package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdSection;

public class ThenSectionsCurrentAppointedStaff extends Stage<ThenSectionsCurrentAppointedStaff> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenSectionsCurrentAppointedStaff.class);

	@ExpectedScenarioState
	private AdAppointment appointment;

	@ExpectedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdSection section;

	public ThenSectionsCurrentAppointedStaff Section_current_appointed_staff_info() {

		Assert.notNull(appointment, "appointment data should be not null");
		Assert.notNull(staff, "staff data should be not null");
		Assert.notNull(section, "section data should be not null");

		LOG.debug("=======view updated appointment staff=========");
		LOG.debug("appointment id: {}", appointment.getId());
		LOG.debug("status {} ", appointment.getStatus());
		LOG.debug("staff: {}", staff.getId());
		LOG.debug("section: {}", section.getCanonicalCode());

		return self();

	}

}
