package my.edu.umk.pams.academic.term.workflow.router;

import my.edu.umk.pams.academic.common.router.RouterServiceSupport;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
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
@Component("admissionApplicationRouter")
public class AdmissionApplicationRouter extends RouterServiceSupport {

    private static final Logger LOG = LoggerFactory.getLogger(AdmissionApplicationRouter.class);

    @Autowired
    private TermService termService;
    
    

    public List<String> findRegistererCandidates(Long admissionApplicationId) {
        Validate.notNull(admissionApplicationId, "Id must not be null");

        String root = null;
        String MGSEB = null;
        AdAdmissionApplication admissionApplication = termService.findAdmissionApplicationById(admissionApplicationId);
        root = "GRP_ADM";
        MGSEB = "GRP_PGW_ADM_MGSEB";

        // publish access event
        // publishAccessEvent(admissionApplication, identityService.findGroupByName(candidate), AcPermission.VIEW);

        return Arrays.asList(root,MGSEB);
    }	

    public List<String> findVerifierCandidates(Long admissionApplicationId) {
        Validate.notNull(admissionApplicationId, "Id must not be null");

        String root = null;
        String MGSEB = null;
        AdAdmissionApplication admissionApplication = termService.findAdmissionApplicationById(admissionApplicationId);
        root = "GRP_ADM";
        MGSEB = "GRP_PGW_ADM_MGSEB";
        
        // publish access event
        // publishAccessEvent(admissionApplication, identityService.findGroupByName(candidate), AcPermission.VIEW);

        return Arrays.asList(root,MGSEB);
    }
}
