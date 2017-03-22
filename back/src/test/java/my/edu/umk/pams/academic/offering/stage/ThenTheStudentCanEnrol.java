package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class ThenTheStudentCanEnrol extends Stage<ThenTheStudentCanEnrol> {
    private static final Logger LOG = LoggerFactory.getLogger(ThenTheStudentCanEnrol.class);

    @Autowired
    private OfferingService offeringService;

    @ExpectedScenarioState
    private AdSection section;

    @ExpectedScenarioState
    private String canonicalCode;

    public ThenTheStudentCanEnrol the_student_can_enrol() {
        LOG.debug("section {} ", section);
        AdSection section = offeringService.findSectionByCanonicalCode(canonicalCode);
        Assert.notNull(section, "The data must not be null");
        return self();
    }
}
