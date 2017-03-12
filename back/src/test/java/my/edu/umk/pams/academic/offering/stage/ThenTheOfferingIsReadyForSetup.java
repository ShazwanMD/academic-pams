package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenTheOfferingIsReadyForSetup extends Stage<ThenTheOfferingIsReadyForSetup> {

    public ThenTheOfferingIsReadyForSetup the_course_is_ready_for_setup() {
        return self();
    }
}
