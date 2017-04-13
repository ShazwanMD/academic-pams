package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmCPSAdministrator extends Stage<GivenIAmCPSAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmCPSAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;
    
    @Autowired
    private IdentityService identityService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdStaff staff;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private AdProgram program;
    
    @ProvidedScenarioState
    private AdStudent student;

    @ProvidedScenarioState
    private AdOffering offering;

    @ProvidedScenarioState
    private AdSection section;
    
    @ProvidedScenarioState
    private AdCourse course;

    public GivenIAmCPSAdministrator I_am_a_CPS_administrator() {
        loginAsCPS();
        return self();
    }

    public GivenIAmCPSAdministrator I_am_a_CPS_administrator_in_$_academic_session(String academicSessionCode) {
        loginAsCPS();
        academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
        return self();
    }

    public GivenIAmCPSAdministrator I_am_a_CPS_administrator_in_current_academic_session() {
        loginAsCPS();
        academicSession = plannerService.findCurrentAcademicSession();
        return self();
    }

    public GivenIAmCPSAdministrator I_pick_faculty_$(String code) {
        faculty = plannerService.findFacultyByCode(code);
        return self();
    }

    public GivenIAmCPSAdministrator I_pick_program_$(String code) {
        program = plannerService.findProgramByCode(code);
        return self();
    }
    
    public GivenIAmCPSAdministrator I_pick_student_$(String identityNo) {
        student = identityService.findStudentByMatricNo(identityNo);
        return self();
    }

    public GivenIAmCPSAdministrator I_pick_offering_$(String canonicalCode) {
        offering = termService.findOfferingByCanonicalCode(canonicalCode);
        return self();
    }

    public GivenIAmCPSAdministrator I_pick_section_$(String canonicalCode) {
        section = termService.findSectionByCanonicalCode(canonicalCode);
        return self();
    }
    
    public GivenIAmCPSAdministrator I_pick_course_$(String code) {
        course = plannerService.findCourseByCode(code);
        return self();
    }

    private void loginAsCPS() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("cps", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        // retrieve staff from user
        AdUser user = ((AdUserDetails) authed.getPrincipal()).getUser();
        staff = (AdStaff) user.getActor();
    }
}
