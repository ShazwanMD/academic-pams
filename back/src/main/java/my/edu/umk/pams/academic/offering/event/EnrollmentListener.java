package my.utm.acad.ac.biz.pko.event;

import my.utm.acad.ac.biz.das.service.DasFinder;
import my.utm.acad.ac.biz.das.service.DasManager;
import my.utm.acad.ac.biz.pko.service.PkoFinder;
import my.utm.acad.ac.biz.pko.service.PkoManager;
import my.utm.acad.ac.biz.ptk.service.PtkFinder;
import my.utm.acad.ac.biz.sys.service.SysFinder;
import my.utm.acad.ac.core.das.model.AcAcademicSession;
import my.utm.acad.ac.core.pko.model.AcEnrollment;
import my.utm.acad.ac.core.das.model.AcSection;
import my.utm.acad.ac.core.sys.model.AcStudent;
import my.utm.acad.proto.core.EnrollmentPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author team utmacad
 * @since 14/10/2015.
 */
@Component("enrollmentListener")
public class EnrollmentListener implements ApplicationListener<EnrollmentEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollmentListener.class);

    @Autowired
    private PkoFinder pkoFinder;

    @Autowired
    private PkoManager pkoManager;

    @Autowired
    private PtkFinder ptkFinder;

    @Autowired
    private DasFinder dasFinder;

    @Autowired
    private SysFinder sysFinder;

    @Autowired
    private DasManager dasManager;


    @Override
    public void onApplicationEvent(EnrollmentEvent event) {
        LOG.debug("onApplicationEvent");

        EnrollmentPayload payload = event.getPayload();
        String sectionCanonicalCode = payload.getSection().getCanonicalCode();
        String matricNo = payload.getStudent().getMatricNo();
        String academicSessionCode = payload.getSession().getCode();

        // unmarshall
        AcAcademicSession academicSession = dasFinder.findAcademicSessionByCode(academicSessionCode);
        AcSection section = ptkFinder.findSectionByCanonicalCode(sectionCanonicalCode);
        AcStudent student = sysFinder.findStudentByIdentityNo(matricNo);
        AcEnrollment enrollment = pkoFinder.findEnrollmentBySectionAndStudent(section, student);

        if (event instanceof EnrollmentConfirmedEvent) {
            // add gradebook
            LOG.debug("adding gradebook");
            pkoManager.addGradebooks(section, enrollment);

        } else if(event instanceof EnrollmentWithdrawnEvent){

        }
    }

}
