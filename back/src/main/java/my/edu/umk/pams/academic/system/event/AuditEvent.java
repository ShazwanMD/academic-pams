package my.edu.umk.pams.academic.system.event;

import my.edu.umk.pams.academic.core.AdMetaObject;
import org.springframework.context.ApplicationEvent;

/**
 * @author canang technologies
 * @since 3/8/14
 */
public class AuditEvent extends ApplicationEvent {

    private AdMetaObject object;
    private String message;

    public AuditEvent(AdMetaObject source, String message) {
        super(source);
        this.object = source;
        this.message = message;
    }

    public AdMetaObject getObject() {
        return object;
    }

    public void setObject(AdMetaObject object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
