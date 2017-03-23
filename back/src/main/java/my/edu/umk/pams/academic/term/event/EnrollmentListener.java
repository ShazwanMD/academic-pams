package my.edu.umk.pams.academic.term.event;

import my.edu.umk.pams.academic.term.service.OfferingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author PAMS
 */
@Component("enrollmentListener")
public class EnrollmentListener implements ApplicationListener<EnrollmentEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollmentListener.class);

    @Autowired
    private OfferingService offeringService;

    @Override
    public void onApplicationEvent(EnrollmentEvent event) {
        LOG.debug("onApplicationEvent");

        // todo(uda): on enrollmentconfirmed
        // todo(uda): add gradebook
    }
}
