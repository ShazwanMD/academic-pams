package my.edu.umk.pams.academic.identity.event;


import my.edu.umk.pams.academic.identity.model.AdStudent;

/**
 * @author PAMS
 */
public class StudentActivatedEvent extends StudentEvent {

    public StudentActivatedEvent(AdStudent vendor) {
        super(vendor);
    }

}
