package my.utm.acad.ac.biz.pko.event;

import my.utm.acad.ac.core.das.model.*;
import my.utm.acad.ac.core.sys.model.AcStudent;
import my.utm.acad.proto.core.EnrollmentEventType;
import my.utm.acad.proto.core.EnrollmentPayload;

import static my.utm.acad.ac.biz.integration.IntegrationUtils.toData;

/**
 * @author team utmacad
 * @since 8/6/2015.
 */
public class EnrollmentConfirmedEvent extends EnrollmentEvent {

    public EnrollmentConfirmedEvent(AcAcademicSession session, AcProgram program, AcCampus campus, AcSite site, AcCohort cohort, AcStudent student, AcSection section) {
        super(new EnrollmentPayload(EnrollmentEventType.CONFIRMED, toData(session), toData(program), toData(campus), toData(site), toData(cohort), toData(student), toData(section)));
    }
}
