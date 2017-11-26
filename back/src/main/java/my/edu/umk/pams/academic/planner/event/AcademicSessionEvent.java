package my.edu.umk.pams.academic.planner.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.AcademicSessionCodePayload;

public class AcademicSessionEvent extends ApplicationEvent {

	public AcademicSessionEvent(AcademicSessionCodePayload payload) {
		super(payload);
		this.payload = payload;
	}
	
	
	private AcademicSessionCodePayload payload;
	
	

	public AcademicSessionCodePayload getPayload() {
		return payload;
	}

	public void setPayload(AcademicSessionCodePayload payload) {
		this.payload = payload;
	}
	
	
	

}
