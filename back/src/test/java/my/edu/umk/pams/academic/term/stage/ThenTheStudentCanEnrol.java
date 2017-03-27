package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
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
    private TermService termService;

    @ExpectedScenarioState
    private AdSection section;

    @ExpectedScenarioState
    private String canonicalCode;

    public ThenTheStudentCanEnrol the_student_can_enrol() {
        LOG.debug("section {} ", section);
        AdSection section = termService.findSectionByCanonicalCode(canonicalCode);
        Assert.notNull(section, "The data must not be null");
        return self();
    }
}
