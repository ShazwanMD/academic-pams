package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.FacultyCodePayload;

/**
 */
public class FacultyRemovedEvent extends FacultyEvent {
    public FacultyRemovedEvent(FacultyCodePayload payload) {
        super(payload);
    }
}
