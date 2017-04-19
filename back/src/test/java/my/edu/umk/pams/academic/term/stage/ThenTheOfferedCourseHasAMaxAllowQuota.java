/**
 * @author PAMS

 */
package my.edu.umk.pams.academic.term.stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

@JGivenStage
public class ThenTheOfferedCourseHasAMaxAllowQuota extends Stage<ThenTheOfferedCourseHasAMaxAllowQuota> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenTheOfferedCourseHasAMaxAllowQuota.class);

    @ExpectedScenarioState
    private String canonicalCode;
    
    @ExpectedScenarioState
    private AdOffering offering;

    public ThenTheOfferedCourseHasAMaxAllowQuota the_offered_course_has_a_maximum_quota() {
       
    	Assert.notNull(offering, "offering data should be not null");
        LOG.debug("==============new offering data====================");
        
    	LOG.debug("New offering Id: {}", offering.getId());
    	LOG.debug("New offering CanonicalCode: {}", offering.getCanonicalCode());
    	LOG.debug("New offering Title: {}", offering.getTitle());
    	LOG.debug("New offering Capacity: {}", offering.getCapacity());
        
        Assert.isTrue(offering.getCapacity() > 0, "Capacity should be greater than zero");
        return self();
    }
}
