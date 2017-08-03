package my.edu.umk.pams.academic.term.event;

import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.math.BigDecimal.ZERO;

/**
 * @author PAMS
 */
@Component("enrollmentListener")
public class EnrollmentListener implements ApplicationListener<EnrollmentEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollmentListener.class);

    @Autowired
    private TermService termService;

    @Override
    public void onApplicationEvent(EnrollmentEvent event) {
        LOG.debug("onApplicationEvent");

        if (event instanceof EnrollmentConfirmedEvent) {
            AdEnrollment enrollment = event.getEnrollment();
            AdSection section = enrollment.getSection();
            AdOffering offering = section.getOffering();
            List<AdAssessment> assessments = termService.findAssessments(offering);
            LOG.debug("found {} assessments ", assessments.size());
            for (AdAssessment assessment : assessments) {
                AdGradebook gradebook = new AdGradebookImpl();
                gradebook.setSection(section);
                gradebook.setAssessment(assessment);
                gradebook.setEnrollment(enrollment);
                gradebook.setScore(ZERO);
               
                termService.addGradebook(section, enrollment, gradebook);
              
            }
        }
    }
}
