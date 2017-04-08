package my.edu.umk.pams.academic.identity.event;


import my.edu.umk.pams.academic.identity.model.AdStudent;

/**
 * @author PAMS
 */
public class StudentCreatedEvent extends StudentEvent {

    public StudentCreatedEvent(AdStudent vendor) {
        super(vendor);
    }

}
