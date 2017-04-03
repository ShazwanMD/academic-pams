package my.edu.umk.pams.bdd.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class GivenIAmAcademicStaff extends Stage<GivenIAmAcademicStaff> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmAcademicStaff.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
	private IdentityService identityService;
	
    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdProgram program;

    @ProvidedScenarioState
    private AdOffering offering;

    @ProvidedScenarioState
    private AdSection section;

    @ProvidedScenarioState
    private AdActor staff;
    
    @ProvidedScenarioState
	AdStudent student;
	
	@ProvidedScenarioState
	AdCourse course;
	
	@ProvidedScenarioState
	AdAddress address;

    public GivenIAmAcademicStaff i_am_a_staff_in_$_academic_session(String academicSessionCode) {
        loginAsStaff();
        academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
        return self();
    }

    public GivenIAmAcademicStaff i_am_a_staff_in_current_academic_session() {
        loginAsStaff();
        academicSession = plannerService.findCurrentAcademicSession();
        return self();
    }

    public GivenIAmAcademicStaff i_pick_program_$(String code) {
        program = plannerService.findProgramByCode(code);
        return self();
    }

    public GivenIAmAcademicStaff i_pick_offering_$(String canonicalCode) {
        offering = termService.findOfferingByCanonicalCode(canonicalCode);
        return self();
    }

    public GivenIAmAcademicStaff i_pick_section_$(String canonicalCode) {
        section = termService.findSectionByCanonicalCode(canonicalCode);
        return self();
    }

    private void loginAsStaff() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("lecturer1", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
        AdUser user = ((AdUserDetails) authed.getPrincipal()).getUser();
        staff = (AdActor) user.getActor();
    }
}
