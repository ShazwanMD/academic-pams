package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.ProgramCodePayload;

/**
 */
public class ProgramAddedEvent extends ProgramEvent {
    public ProgramAddedEvent(ProgramCodePayload payload) {
        super(payload);
    }
}
