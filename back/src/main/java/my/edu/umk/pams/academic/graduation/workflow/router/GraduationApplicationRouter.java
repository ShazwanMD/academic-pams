package my.edu.umk.pams.academic.graduation.workflow.router;

import my.edu.umk.pams.academic.common.router.RouterServiceSupport;
import my.edu.umk.pams.academic.common.router.RouterStrategy;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import my.edu.umk.pams.academic.security.service.AccessService;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.term.workflow.router.CPSRouterStrategy;
import my.edu.umk.pams.academic.term.workflow.router.MGSEBRouterStrategy;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    @Autowired
    private TermService termService;
    
    @Autowired
    private PlannerService plannerService;
    
    @Autowired
    private CommonService commonService;
    
    private static Map<String, RouterStrategy> strategies = new HashMap<String, RouterStrategy>();

    static {
        strategies.put("MGSEB", new MGSEBRouterStrategy());
        strategies.put("CPS", new CPSRouterStrategy());
    }
    
    public List<String> findRegistererCandidates(Long graduationApplicationId) {
        Validate.notNull(graduationApplicationId, "Id must not be null");

        String root = null;
        String CPS = null;
        String MGSEB = null;
        //String kerani = null;
        AdGraduationApplication application = graduationService.findGraduationApplicationById(graduationApplicationId);
        root = "GRP_ADM";
        CPS = "GRP_PGW_ADM_CPS";
        MGSEB = "GRP_PGW_ADM_MGSEB";

        return Arrays.asList(root,MGSEB,CPS);
    }

    public List<String> findVerifierCandidates(Long graduationApplicationId) {
        Validate.notNull(graduationApplicationId, "Id must not be null");

        String CPS = null;
        String root = null;
        String MGSEB = null;
        AdGraduationApplication application = graduationService.findGraduationApplicationById(graduationApplicationId);
        CPS = "GRP_PGW_ADM_CPS";
        root = "GRP_ADM";
        MGSEB = "GRP_PGW_ADM_MGSEB";

        return Arrays.asList(CPS,root,MGSEB);
    }
}
