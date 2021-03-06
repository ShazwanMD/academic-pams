package my.edu.umk.pams.academic.term.workflow.router;

import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.router.RouterServiceSupport;
import my.edu.umk.pams.academic.common.router.RouterStrategy;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.service.TermService;

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
@Component("admissionApplicationRouter")
public class AdmissionApplicationRouter extends RouterServiceSupport {

    private static final Logger LOG = LoggerFactory.getLogger(AdmissionApplicationRouter.class);

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
    
    public List<String> findRegistererCandidates(Long admissionApplicationId) {
        Validate.notNull(admissionApplicationId, "Id must not be null");

        AdAdmissionApplication admissionApplication = termService.findAdmissionApplicationById(admissionApplicationId);
        
        String code = admissionApplication.getProgram().getFaculty().getCenter().getCode();

        RouterStrategy strategy = strategies.get(code);
        
        List<String> candidates = strategy.findRegistererCandidates();

        return candidates;
    }	

    public List<String> findVerifierCandidates(Long admissionApplicationId) {
        Validate.notNull(admissionApplicationId, "Id must not be null");


        AdAdmissionApplication admissionApplication = termService.findAdmissionApplicationById(admissionApplicationId);
        
        String code = admissionApplication.getProgram().getFaculty().getCenter().getCode();

        RouterStrategy strategy = strategies.get(code);
        
        List<String> candidates = strategy.findVerifierCandidates();

        return candidates;
    }
}
