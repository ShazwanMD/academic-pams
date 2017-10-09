package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.CohortCodePayload;

public class CohortCancelledEvent extends CohortEvent {

	public CohortCancelledEvent(CohortCodePayload payload) {
		super(payload);
	}
	

}
