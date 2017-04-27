package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmAdministrator extends Stage<GivenIAmAdministrator> {

	private static final Logger LOG = LoggerFactory.getLogger(GivenIAmAdministrator.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdUser user;

	@ProvidedScenarioState
	private AdActor staff;

	public void i_am_a_$_administrator_in_$_academic_session(String academicSessionCode, String username,
			String password) {
		loginAsAdmin(username, password);
		academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
	}

	public void i_am_a_$_administrator_in_current_academic_session(String username, String password) {
		loginAsAdmin(username, password);
		academicSession = plannerService.findCurrentAcademicSession();
	}

	private void loginAsAdmin(String username, String password) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

		Authentication authed = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authed);

		user = ((AdUserDetails) authed.getPrincipal()).getUser();
		staff = (AdActor) user.getActor();

	}

}
