package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.ProgramCodePayload;

/**
 */
public class ProgramRemovedEvent extends ProgramEvent {
    public ProgramRemovedEvent(ProgramCodePayload payload) {
        super(payload);
    }
}
