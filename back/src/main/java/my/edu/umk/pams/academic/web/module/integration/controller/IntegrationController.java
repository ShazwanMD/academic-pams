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

import java.math.BigDecimal;
import java.util.List;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.connector.payload.AccountPayload;
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
    
    @Autowired
    private ProfileService profileService;

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
    // STUDENT ACCOUNT
    // ====================================================================================================
    @RequestMapping(value = "/candidates", method = RequestMethod.POST)
    public ResponseEntity<String> saveStudentAccount(@RequestBody AccountPayload payload) {
        SecurityContext ctx = loginAsSystem();
        
        AdStudent student = identityService.findStudentByMatricNo(payload.getMatricNo());
        student.setBalance(payload.getBalance());
        student.setOutstanding(payload.isOutstanding());
        identityService.updateStudent(student);
     
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
        student.setMatricNo(payload.getMatricNo());
        student.setName(payload.getName());
        student.setEmail(payload.getEmail());
        student.setFax(payload.getFax());
        student.setPhone(payload.getPhone());
        student.setMobile(payload.getMobile());

        // status, mode and cohort
        student.setStudentStatus(AdStudentStatus.MATRICULATED);
        student.setStudyMode(commonService.findStudyModeByCode(payload.getStudyMode().getCode()));
        student.setCohort(plannerService.findCohortByCode(payload.getCohortCode()));
        student.setBalance(BigDecimal.ZERO);
        student.setOutstanding(false);

        identityService.saveStudent(student);
               
        //Mailing Address
        AdAddress currentAddress = new AdAddressImpl();
        currentAddress.setAddress1(payload.getSecondaryAddress().getAddress1());
        currentAddress.setAddress2(payload.getSecondaryAddress().getAddress2());
        currentAddress.setAddress3(payload.getSecondaryAddress().getAddress3());
        currentAddress.setPostCode(payload.getSecondaryAddress().getPostcode());
        currentAddress.setStateCode(commonService.findStateCodeByCode(payload.getSecondaryAddress().getStateCode()));
        currentAddress.setCountryCode(commonService.findCountryCodeByCode(payload.getSecondaryAddress().getCountryCode()));
        currentAddress.setStudent(student);
        currentAddress.setType(AdAddressType.CURRENT);
        profileService.addAddress(student, currentAddress);

        //Billing Address
        AdAddress permenantAddress = new AdAddressImpl();
        permenantAddress.setAddress1(payload.getPrimaryAddress().getAddress1());
        permenantAddress.setAddress2(payload.getPrimaryAddress().getAddress2());
        permenantAddress.setAddress3(payload.getPrimaryAddress().getAddress3());
        permenantAddress.setPostCode(payload.getPrimaryAddress().getPostcode());
        permenantAddress.setStateCode(commonService.findStateCodeByCode(payload.getPrimaryAddress().getStateCode()));
        permenantAddress.setCountryCode(commonService.findCountryCodeByCode(payload.getPrimaryAddress().getCountryCode()));
        permenantAddress.setStudent(student);
        permenantAddress.setType(AdAddressType.PERMANENT);
        profileService.addAddress(student, permenantAddress);

        // todo: refresh and save address etc
        // todo: save student sebagai users
        // todo: set initial password
        // todo: hantar email notification dan sebagainnya
        // todo: current, permanent
        

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
