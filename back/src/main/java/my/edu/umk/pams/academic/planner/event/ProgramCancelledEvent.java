package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.ProgramCodePayload;

/**
 */
public class ProgramCancelledEvent extends ProgramEvent {
    public ProgramCancelledEvent(ProgramCodePayload payload) {
        super(payload);
    }
}
