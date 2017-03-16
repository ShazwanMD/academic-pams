package my.utm.acad.ac.biz.pko.event;

import my.utm.acad.proto.core.EnrollmentPayload;
import org.springframework.context.ApplicationEvent;

/**
 * @author team utmacad
 * @since 15/8/2015.
 */
public class EnrollmentEvent extends ApplicationEvent {

    private EnrollmentPayload payload;

    public EnrollmentEvent(EnrollmentPayload payload) {
        super(payload);
        this.payload = payload;
    }

    public EnrollmentPayload getPayload() {
        return payload;
    }

    public void setPayload(EnrollmentPayload payload) {
        this.payload = payload;
    }
}
