package my.edu.umk.pams.academic.identity.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.GuardianPayload;

public class GuardianEvent extends ApplicationEvent{

	public GuardianEvent(GuardianPayload payload) {
		super(payload);
		this.payload = payload;
	}

	
	private GuardianPayload payload;


	public GuardianPayload getPayload() {
		return payload;
	}


	public void setPayload(GuardianPayload payload) {
		this.payload = payload;
	}
	

}
