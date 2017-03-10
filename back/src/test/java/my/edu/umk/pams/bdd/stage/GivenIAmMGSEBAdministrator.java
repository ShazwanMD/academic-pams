package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmMGSEBAdministrator extends Stage<GivenIAmMGSEBAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmMGSEBAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudyplanService studyplanService;

    @ProvidedScenarioState
    AdAcademicSession academicSession;

    public void I_am_a_PPS_administrator_in_$_academic_session(String academicSessionCode){
        loginAsMGSEB();
        academicSession = studyplanService.findAcademicSessionByCode(academicSessionCode);
    }

    public void I_am_a_PPS_administrator_in_current_academic_session(){
        loginAsMGSEB();
        academicSession = studyplanService.findCurrentAcademicSession();
    }

    private void loginAsMGSEB() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("mgseb", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
