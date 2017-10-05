package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.CohortCodePayload;

public class CohortAddedEvent extends CohortEvent {

	public CohortAddedEvent(CohortCodePayload payload) {
		super(payload);
	}
	

}
