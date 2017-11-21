package my.edu.umk.pams.academic.identity.event;

import my.edu.umk.pams.connector.payload.MinAmountPayload;

public class MinAmountAddedEvent extends MinAmountEvent {

	public MinAmountAddedEvent(MinAmountPayload payload) {
		super(payload);
	}

}
