package my.edu.umk.pams.academic.term.stage;

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
 * @author asyikin.mr
 */
@JGivenStage
public class ThenTheStatusIsUpdated extends Stage<ThenTheStatusIsUpdated> {

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @Autowired
    private PlannerService plannerService;

    private static final Logger LOG = LoggerFactory.getLogger(ThenTheStudentCanEnrol.class);

    public ThenTheStatusIsUpdated the_status_is_updated() {

        LOG.debug("academicSession {} ", academicSession);
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        Assert.notNull(academicSession, "The data must not be null");

        return self();

    }
}
