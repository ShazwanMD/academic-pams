package my.edu.umk.pams.academic.identity.event;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import org.springframework.context.ApplicationEvent;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class ApplicantUpdatedEvent extends ApplicationEvent {

    public ApplicantUpdatedEvent(AdStudent applicant) {
        super(applicant);
    }
}
