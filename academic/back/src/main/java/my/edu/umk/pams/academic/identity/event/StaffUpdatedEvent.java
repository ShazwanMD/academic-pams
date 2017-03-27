package my.edu.umk.pams.academic.identity.event;

import my.edu.umk.pams.academic.identity.model.AdStaff;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class StaffUpdatedEvent extends StaffEvent {

    public StaffUpdatedEvent(AdStaff staff) {
        super(staff);
    }
}
