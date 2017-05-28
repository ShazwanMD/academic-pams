package my.edu.umk.pams.academic.graduation.workflow.router;

import my.edu.umk.pams.academic.common.router.RouterServiceSupport;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
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
@Component("graduationApplicationRouter")
public class GraduationApplicationRouter extends RouterServiceSupport {

    private static final Logger LOG = LoggerFactory.getLogger(GraduationApplicationRouter.class);

    @Autowired
    private GraduationService graduationService;

    public List<String> findRegistererCandidates(Long graduationApplicationId) {
        Validate.notNull(graduationApplicationId, "Id must not be null");

        String candidate = null;
        AdGraduationApplication application = graduationService.findGraduationApplicationById(graduationApplicationId);
        candidate = "GRP_ADM";

        // publish access event
        // publishAccessEvent(creditNote, identityService.findGroupByName(candidate), AcPermission.VIEW);

        return Arrays.asList(candidate);
    }

    public List<String> findVerifierCandidates(Long graduationApplicationId) {
        Validate.notNull(graduationApplicationId, "Id must not be null");

        String candidate = null;
        AdGraduationApplication application = graduationService.findGraduationApplicationById(graduationApplicationId);
        candidate = "GRP_ADM";

        // publish access event
        // publishAccessEvent(creditNote, identityService.findGroupByName(candidate), AcPermission.VIEW);

        return Arrays.asList(candidate);
    }
}
