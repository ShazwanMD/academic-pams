package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.FacultyCodePayload;

/**
 */
public class FacultyAddedEvent extends FacultyEvent {
    public FacultyAddedEvent(FacultyCodePayload payload) {
        super(payload);
    }
}
