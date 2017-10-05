package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.CohortCodePayload;

public class CohortRemovedEvent extends CohortEvent {

	public CohortRemovedEvent(CohortCodePayload payload) {
		super(payload);
	}
	

}
