/**
 * @author PAMS
 */

package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenTheOfferedCourseHasAMaxAllowQuota extends Stage<ThenTheOfferedCourseHasAMaxAllowQuota> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenTheOfferedCourseHasAMaxAllowQuota.class);

    @Autowired
    private OfferingService offeringService;

    @ExpectedScenarioState
    private String canonicalCode;

    public ThenTheOfferedCourseHasAMaxAllowQuota the_offered_course_has_a_maximum_quota() {
        LOG.debug("canonicalCode: {}", canonicalCode);
        AdOffering offering = offeringService.findOfferingByCanonicalCode(canonicalCode);
        Assert.isTrue(offering.getCapacity() > 0, "Capacity should be greater than zero");
        return self();
    }
}
