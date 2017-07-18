package my.edu.umk.pams.academic.planner.stage;

/**
 * I Am Student
 * I Review Course Info
 * Course Information Reviewed
 *
 * @author zaida
 */

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class WhenAggregateAllSessions extends Stage<WhenAggregateAllSessions> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAggregateAllSessions.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;

    @ProvidedScenarioState
    private AdStudent student;

    @ProvidedScenarioState
    private List<AdAdmissionApplication> applications;

    @ProvidedScenarioState
    private List<AdAcademicSession> academicSessions;

    public WhenAggregateAllSessions I_gather_aggregate_applications() {

        academicSessions = plannerService.findAcademicSessions(0, 9999); // get all
        final int ACTUAL = academicSessions.size();
        final int EXPECTED = 3; // This is all we have now
        LOG.debug("Found {} AcademicSessions for ALL times", ACTUAL);
        Assert.isTrue(EXPECTED >= ACTUAL, "Expected " + EXPECTED + " but found " + ACTUAL);

        academicSessions.forEach(a -> {
            String format = "AcademicSession {} {} has {} applications";

            applications = termService.findAdmissionApplications(a);
            Object[] array = {a.getCode(), a.getSemester(), applications.size()};
            LOG.debug(format, array);
        });


        return self();
    }
}