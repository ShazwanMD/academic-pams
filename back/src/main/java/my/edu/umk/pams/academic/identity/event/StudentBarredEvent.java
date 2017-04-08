package my.edu.umk.pams.academic.identity.event;


import my.edu.umk.pams.academic.identity.model.AdStudent;

/**
 * @author PAMS
 */
public class StudentBarredEvent extends StudentEvent {

    public StudentBarredEvent(AdStudent student) {
        super(student);
    }

}
