package my.edu.umk.pams.academic.identity.event;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class StudentEvent extends org.springframework.context.ApplicationEvent {

    public StudentEvent(Object source) {
        super(source);
    }
}
