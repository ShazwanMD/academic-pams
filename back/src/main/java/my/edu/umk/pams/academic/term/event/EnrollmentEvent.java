package my.edu.umk.pams.academic.term.event;

import my.edu.umk.pams.academic.term.model.AdEnrollment;
import org.springframework.context.ApplicationEvent;

/**
 * @author PAMS
 */
public class EnrollmentEvent extends ApplicationEvent {

    private AdEnrollment enrollment;

    public EnrollmentEvent(AdEnrollment enrollment) {
        super(enrollment);
        this.enrollment = enrollment;
    }

    public AdEnrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(AdEnrollment enrollment) {
        this.enrollment = enrollment;
    }
}
