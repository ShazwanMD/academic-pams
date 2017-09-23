package my.edu.umk.pams.academic.graduation.workflow.router;

import my.edu.umk.pams.academic.common.router.RouterServiceSupport;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import my.edu.umk.pams.academic.security.service.AccessService;

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
    
    @Autowired
    private AccessService accessService;
    
    public List<String> findRegistererCandidates(Long graduationApplicationId) {
        Validate.notNull(graduationApplicationId, "Id must not be null");

        String root = null;
        String pegawai = null;
        String MGSEB = null;
        //String kerani = null;
        AdGraduationApplication application = graduationService.findGraduationApplicationById(graduationApplicationId);
        root = "GRP_ADM";
        pegawai = "GRP_PGW_ADM_CPS";
        MGSEB = "GRP_PGW_ADM_MGSEB";
        //kerani = "GRP_KRN_ADM_CPS";

//        if(accessService.checkPermission(application, identityService.findGroupByName(kerani), AdPermission.VIEW)){
//        	  publishAccessEvent(application, identityService.findGroupByName(kerani), AdPermission.VIEW);
//        }else if(accessService.checkPermission(application, identityService.findGroupByName(pegawai), AdPermission.VIEW)
//        		&& accessService.checkPermission(application, identityService.findGroupByName(pegawai), AdPermission.UPDATE)){
//        	
//            publishAccessEvent(application, identityService.findGroupByName(pegawai), AdPermission.VIEW);
//            publishAccessEvent(application, identityService.findGroupByName(pegawai), AdPermission.UPDATE);
//        }
        // publish access event
        // publishAccessEvent(application, identityService.findGroupByName(kerani), AdPermission.VIEW);
         //publishAccessEvent(application, identityService.findGroupByName(kerani), AdPermission.UPDATE);
         
  
        //return Arrays.asList(pegawai);
        return Arrays.asList(root,MGSEB,pegawai );
    }

    public List<String> findVerifierCandidates(Long graduationApplicationId) {
        Validate.notNull(graduationApplicationId, "Id must not be null");

        String candidate = null;
        String root = null;
        String MGSEB = null;
        AdGraduationApplication application = graduationService.findGraduationApplicationById(graduationApplicationId);
        candidate = "GRP_PGW_ADM_CPS";
        root = "GRP_ADM";
        MGSEB = "GRP_PGW_ADM_MGSEB";

        // publish access event
        // publishAccessEvent(creditNote, identityService.findGroupByName(candidate), AcPermission.VIEW);

        //return Arrays.asList(candidate);
        return Arrays.asList(candidate,root,MGSEB);
    }
}
