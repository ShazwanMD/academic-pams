/**
 * @author asyikin.mr 
 * todo:asyikin
 */
package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheStatusAppointmentIsUpdated extends Stage<ThenTheStatusAppointmentIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheStatusAppointmentIsUpdated.class);

	public ThenTheStatusAppointmentIsUpdated the_appointment_status_is_updated() {
		return self();
	}
}
