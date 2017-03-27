package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmCPSKeraniAdministrator extends Stage<GivenIAmCPSKeraniAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmCPSKeraniAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PlannerService plannerService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdStaff staff;

    public void I_am_a_CPS_administrator_in_$_academic_session(String academicSessionCode) {
        loginAsCPS();
        academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
    }

    public void I_am_a_CPS_administrator_in_current_academic_session() {
        loginAsCPS();
        academicSession = plannerService.findCurrentAcademicSession();
    }

    private void loginAsCPS() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("cps-kerani", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        // retrieve staff from user
        AdUser user = ((AdUserDetails) authed.getPrincipal()).getUser();
        staff = (AdStaff) user.getActor();
    }
}
