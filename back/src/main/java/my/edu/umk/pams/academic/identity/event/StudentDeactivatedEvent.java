package my.edu.umk.pams.academic.identity.event;


import my.edu.umk.pams.academic.identity.model.AdStudent;

/**
 * @author PAMS
 */
public class StudentDeactivatedEvent extends StudentEvent {

    public StudentDeactivatedEvent(AdStudent vendor) {
        super(vendor);
    }

}
