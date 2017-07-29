package my.edu.umk.pams.academic.planner.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.FacultyCodePayload;

/**
 */
public class FacultyEvent extends ApplicationEvent {

    private FacultyCodePayload payload;

    public FacultyEvent(FacultyCodePayload payload) {
        super(payload);
        this.payload = payload;
    }

    public FacultyCodePayload getPayload() {
        return payload;
    }

    public void setPayload(FacultyCodePayload payload) {
        this.payload = payload;
    }
}
