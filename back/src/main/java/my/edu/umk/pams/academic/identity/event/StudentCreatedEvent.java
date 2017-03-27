package my.edu.umk.pams.academic.identity.event;


import my.edu.umk.pams.academic.identity.model.AdStudent;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class StudentCreatedEvent extends StudentEvent {

    public StudentCreatedEvent(AdStudent vendor) {
        super(vendor);
    }

}
