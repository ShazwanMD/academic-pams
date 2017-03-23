package my.edu.umk.pams.academic.term.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author PAMS
 */
public class EnrollmentEvent extends ApplicationEvent {

    public EnrollmentEvent() {
        super(null);
    }
}
