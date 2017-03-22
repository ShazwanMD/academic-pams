package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmBursary extends Stage<GivenIAmBursary> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmBursary.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudyplanService studyplanService;

    @Autowired
    private OfferingService offeringService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdStaff staff;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private AdProgram program;

    @ProvidedScenarioState
    private AdOffering offering;

    public GivenIAmBursary I_am_a_bursary_in_$_academic_session(String academicSessionCode) {
        loginAsBursary();
        academicSession = studyplanService.findAcademicSessionByCode(academicSessionCode);
        return self();
    }

    public GivenIAmBursary I_am_a_bursary_in_current_academic_session() {
        loginAsBursary();
        academicSession = studyplanService.findCurrentAcademicSession();
        return self();
    }

    public GivenIAmBursary I_pick_faculty_$(String code) {
        faculty = studyplanService.findFacultyByCode(code);
        return self();
    }

    public GivenIAmBursary I_pick_program_$(String code) {
        program = studyplanService.findProgramByCode(code);
        return self();
    }

    public GivenIAmBursary I_pick_offering_$(String canonicalCode) {
        offering = offeringService.findOfferingByCanonicalCode(canonicalCode);
        return self();
    }

    private void loginAsBursary() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("bursary", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        // retrieve staff from user
        AdUser user = ((AdUserDetails) authed.getPrincipal()).getUser();
        staff = (AdStaff) user.getActor();
    }
}
