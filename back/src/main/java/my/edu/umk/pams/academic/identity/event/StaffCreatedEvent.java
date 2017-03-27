package my.edu.umk.pams.academic.identity.event;


import my.edu.umk.pams.academic.identity.model.AdStaff;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class StaffCreatedEvent extends StaffEvent {

    public StaffCreatedEvent(AdStaff Staff) {
        super(Staff);
    }

}
