/**
 * @author asyikin.mr
 * todo: asyikin
 */
package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIWantToUpdateAppointmentStatus extends Stage<WhenIWantToUpdateAppointmentStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToUpdateAppointmentStatus.class);

	public WhenIWantToUpdateAppointmentStatus I_update_appointment_status() {
		return self();
	}
}