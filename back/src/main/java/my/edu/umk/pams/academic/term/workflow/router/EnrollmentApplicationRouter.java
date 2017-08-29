package my.edu.umk.pams.academic.term.workflow.router;

import my.edu.umk.pams.academic.common.router.RouterServiceSupport;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author PAMS
 */
@Component("enrollmentApplicationRouter")
public class EnrollmentApplicationRouter extends RouterServiceSupport {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollmentApplicationRouter.class);

    @Autowired
    private TermService termService;

    public List<String> findRegistererCandidates(Long enrollmentApplicationId) {
        Validate.notNull(enrollmentApplicationId, "Id must not be null");

        String ROOT = null;
        String MGSEB = null;
        AdEnrollmentApplication enrollmentApplication = termService.findEnrollmentApplicationById(enrollmentApplicationId);
        ROOT = "GRP_ADM";
        MGSEB = "GRP_PGW_ADM_MGSEB";

        // publish access event
        // publishAccessEvent(enrollmentApplication, identityService.findGroupByName(candidate), AcPermission.VIEW);

        return Arrays.asList(ROOT,MGSEB);
    }

    public List<String> findVerifierCandidates(Long enrollmentApplicationId) {
        Validate.notNull(enrollmentApplicationId, "Id must not be null");

        String ROOT = null;
        String MGSEB = null;

        AdEnrollmentApplication enrollmentApplication = termService.findEnrollmentApplicationById(enrollmentApplicationId);
        ROOT = "GRP_ADM";
        MGSEB = "GRP_PGW_ADM_MGSEB";

        // publish access event
        // publishAccessEvent(enrollmentApplication, identityService.findGroupByName(candidate), AcPermission.VIEW);

        return Arrays.asList(ROOT,MGSEB);
    }
}
