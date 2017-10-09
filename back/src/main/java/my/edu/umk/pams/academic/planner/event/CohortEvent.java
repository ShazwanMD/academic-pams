package my.edu.umk.pams.academic.planner.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.CohortCodePayload;

public class CohortEvent extends ApplicationEvent {
	
	private CohortCodePayload payload;
	
	public CohortEvent(CohortCodePayload payload) {
		super(payload);
		this.payload =payload;
		
	}
	
	public CohortCodePayload getPayload(){
		return payload;
	}

	public void setPayload(CohortCodePayload payload) {
		this.payload = payload;
	}

}
