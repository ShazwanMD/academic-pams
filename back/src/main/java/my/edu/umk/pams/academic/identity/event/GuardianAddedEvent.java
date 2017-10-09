package my.edu.umk.pams.academic.identity.event;

import my.edu.umk.pams.connector.payload.GuardianPayload;

public class GuardianAddedEvent extends GuardianEvent {

	public GuardianAddedEvent(GuardianPayload payload) {
		super(payload);
	}

}
