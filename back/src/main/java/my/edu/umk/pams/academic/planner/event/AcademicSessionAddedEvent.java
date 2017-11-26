package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.AcademicSessionCodePayload;

public class AcademicSessionAddedEvent extends AcademicSessionEvent {

	public AcademicSessionAddedEvent(AcademicSessionCodePayload payload) {
		super(payload);
	}

}
