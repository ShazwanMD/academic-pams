package my.edu.umk.pams.academic.term.event;

import my.edu.umk.pams.academic.term.model.AdEnrollment;

/**
 * @author PAMS
 */
public class EnrollmentWithdrawnEvent extends EnrollmentEvent {

    public EnrollmentWithdrawnEvent(AdEnrollment enrollment) {
        super(enrollment);
    }
}
