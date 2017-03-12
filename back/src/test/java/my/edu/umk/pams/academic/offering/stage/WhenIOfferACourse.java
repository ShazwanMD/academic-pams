package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIOfferACourse extends Stage<WhenIOfferACourse> {

    public WhenIOfferACourse I_offer_a_course() {
        return self();
    }
}
