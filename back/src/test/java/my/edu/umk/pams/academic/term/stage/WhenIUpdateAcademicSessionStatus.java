package my.edu.umk.pams.academic.term.stage;
/**
 * @author asyikin.mr
 */

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

@JGivenStage
public class WhenIUpdateAcademicSessionStatus extends Stage<WhenIUpdateAcademicSessionStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAcademicSessionStatus.class);

    @Autowired
    private PlannerService plannerService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private String code;

    @ExpectedScenarioState
    private AdAcademicSession previous;

    public WhenIUpdateAcademicSessionStatus I_update_academic_session_status() {

        Calendar now = Calendar.getInstance();
        code = (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);

        academicSession = new AdAcademicSessionImpl();
        academicSession.setCode(code);
        academicSession.setCurrent(true);
        academicSession.setDescription("Sesi 09/2017/2018");
        academicSession.setStatus(AdAcademicStatus.NEW);

        plannerService.updateAcademicSession(academicSession);

        LOG.debug("academicSession {} ", academicSession);
        return self();
    }
}
