package my.edu.umk.pams.academic.term.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author PAMS
 */
public class AppointmentEvent extends ApplicationEvent {


    public AppointmentEvent() {
        super(null);
    }

}
