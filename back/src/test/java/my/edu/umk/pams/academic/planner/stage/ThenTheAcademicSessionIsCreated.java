//package my.edu.umk.pams.academic.planner.stage;

//public class ThenTheStatusIsUpdated {

//}

package my.edu.umk.pams.academic.planner.stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author zaida.n
 */
@JGivenStage
public class ThenTheAcademicSessionIsCreated extends Stage<ThenTheAcademicSessionIsCreated> {

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @Autowired
    private PlannerService plannerService;

    private static final Logger LOG = LoggerFactory.getLogger(ThenTheAcademicSessionIsCreated.class);

    public ThenTheAcademicSessionIsCreated the_academic_session_is_created() {

        LOG.debug("academicSession {} ", academicSession);
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        Assert.notNull(academicSession, "The data must not be null");

        return self();

    }
}
