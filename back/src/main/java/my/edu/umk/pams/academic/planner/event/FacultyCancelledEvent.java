package my.edu.umk.pams.academic.planner.event;

import my.edu.umk.pams.connector.payload.FacultyCodePayload;

/**
 */
public class FacultyCancelledEvent extends FacultyEvent {
    public FacultyCancelledEvent(FacultyCodePayload payload) {
        super(payload);
    }
}
