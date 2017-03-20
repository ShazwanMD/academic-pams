package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmPPSAdministrator extends Stage<GivenIAmPPSAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmPPSAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudyplanService studyplanService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdStaff staff;

    @ProvidedScenarioState
    private AdFaculty faculty;

    public void I_am_a_PPS_administrator(){
        loginAsPPS();
    }

    public GivenIAmPPSAdministrator I_am_a_PPS_administrator_in_$_academic_session(String academicSessionCode){
        loginAsPPS();
        academicSession = studyplanService.findAcademicSessionByCode(academicSessionCode);
        return self();
    }

    public GivenIAmPPSAdministrator I_am_a_PPS_administrator_in_current_academic_session(){
        loginAsPPS();
        academicSession = studyplanService.findCurrentAcademicSession();
        return self();
    }

    public GivenIAmPPSAdministrator I_pick_faculty_$(String code){
        faculty = studyplanService.findFacultyByCode(code);
        return self();
    }

    private void loginAsPPS() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("pps", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        // retrieve staff from user
        AdUser user = ((AdUserDetails) authed.getPrincipal()).getUser();
        staff = (AdStaff) user.getActor();
    }
}
