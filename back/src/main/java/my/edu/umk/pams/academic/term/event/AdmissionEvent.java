package my.edu.umk.pams.academic.term.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.AdmissionPayload;

/**
 * @author PAMS
 */
public class AdmissionEvent extends ApplicationEvent {

	private AdmissionPayload payload;
	
    public AdmissionEvent(AdmissionPayload payload) {
        super(payload);
        this.payload = payload;
    }
    
    public AdmissionPayload getPayload(){
    	return payload;
    }
    
    public void setPayload(AdmissionPayload payload){
    	this.payload = payload;
    }
}
