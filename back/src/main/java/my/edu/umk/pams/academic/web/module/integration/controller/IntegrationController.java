package my.edu.umk.pams.academic.web.module.integration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.dsl.http.Http;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.connector.payload.CandidatePayload;

/**
 */
@Transactional
@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

    private static final Logger LOG = LoggerFactory.getLogger(IntegrationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;

    // ====================================================================================================
    // COHORT
    // ====================================================================================================
    @RequestMapping(value = "/cohort", method = RequestMethod.POST)
    public ResponseEntity<String> saveCohort() {
        SecurityContext ctx = loginAsSystem();

        AdCohort cohort = new AdCohortImpl();
        cohort.setCode("TODO");
        cohort.setDescription("TODO");
        cohort.setProgram(plannerService.findProgramByCode("TODO"));
        cohort.setCurriculum(plannerService.findCurriculumByCode("TODO"));
        cohort.setSession(plannerService.findCurrentAcademicSession());
        plannerService.saveCohort(cohort);

        logoutAsSystem(ctx);
        return new ResponseEntity<String>("sucess", HttpStatus.OK);
    }

    // ====================================================================================================
    // CANDIDATE
    // ====================================================================================================
    @RequestMapping(value = "/candidates", method = RequestMethod.POST)
    public ResponseEntity<String> saveCandidate(@RequestBody CandidatePayload payload) {
        SecurityContext ctx = loginAsSystem();

        // student info
        AdStudent student = new AdStudentImpl();
        student.setMatricNo("TODO");
        student.setName("TODO");
        student.setEmail("TODO");
        student.setFax("TODO");
        student.setPhone("TODO");
        student.setMobile("TODO");

        // status, mode and cohort
        student.setStudentStatus(AdStudentStatus.MATRICULATED);
        student.setStudyMode(commonService.findStudyModeByCode("P"));
        student.setCohort(plannerService.findCohortByCode("TODO"));

        identityService.saveStudent(student);

        // todo: refresh and save address etc

        logoutAsSystem(ctx);
        return new ResponseEntity<String>("sucess", HttpStatus.OK);
    }

    private SecurityContext loginAsSystem() {
        SecurityContext savedCtx = SecurityContextHolder.getContext();
        AdAutoLoginToken authenticationToken = new AdAutoLoginToken("system");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContext system = new NonSerializableSecurityContext();
        system.setAuthentication(authed);
        SecurityContextHolder.setContext(system);
        return savedCtx;
    }

    private void logoutAsSystem(SecurityContext context) {
        SecurityContextHolder.setContext(context);
    }
}
