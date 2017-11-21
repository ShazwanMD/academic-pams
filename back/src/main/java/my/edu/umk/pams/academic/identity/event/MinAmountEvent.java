package my.edu.umk.pams.academic.identity.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.MinAmountPayload;


public class MinAmountEvent extends ApplicationEvent {

	public MinAmountEvent(MinAmountPayload payload) {
		super(payload);
		this.payload = payload;
		
	}
	
	private MinAmountPayload payload;

	public MinAmountPayload getPayload() {
		return payload;
	}

	public void setPayload(MinAmountPayload payload) {
		this.payload = payload;
	}
	
	
	

}
