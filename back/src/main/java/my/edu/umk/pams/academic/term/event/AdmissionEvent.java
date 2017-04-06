package my.edu.umk.pams.academic.term.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author PAMS
 */
public class AdmissionEvent extends ApplicationEvent {

    public AdmissionEvent() {
        super(null);
    }
}
