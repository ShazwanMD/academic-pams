package my.edu.umk.pams.academic.term.event;

import my.edu.umk.pams.academic.term.model.AdEnrollment;

/**
 * @author PAMS
 */
public class EnrollmentConfirmedEvent extends EnrollmentEvent {

    public EnrollmentConfirmedEvent(AdEnrollment enrollment) {
        super(enrollment);
    }
}
