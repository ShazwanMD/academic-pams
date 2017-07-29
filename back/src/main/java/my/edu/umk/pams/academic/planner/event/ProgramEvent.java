package my.edu.umk.pams.academic.planner.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.connector.payload.ProgramCodePayload;

/**
 */
public class ProgramEvent extends ApplicationEvent {

    private ProgramCodePayload payload;

    public ProgramEvent(ProgramCodePayload payload) {
        super(payload);
        this.payload = payload;
    }

    public ProgramCodePayload getPayload() {
        return payload;
    }

    public void setPayload(ProgramCodePayload payload) {
        this.payload = payload;
    }
}
