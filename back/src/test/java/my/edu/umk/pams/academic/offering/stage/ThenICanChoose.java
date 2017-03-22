package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenICanChoose extends Stage<ThenICanChoose> {

    @Autowired
    private OfferingService offeringService;

    @ExpectedScenarioState
    private List<AdOffering> offerings;

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanChoose.class);

    public ThenICanChoose i_can_choose_which_section_to_enroll() {
        // iterate thru expected offerings
        // try to find section to enroll
        for (AdOffering offering : offerings) {
            List<AdSection> sections = offeringService.findSections(offering);
            for (AdSection section : sections) {
                // check if section has exceeded capacity
                boolean exceededEnrollment = offeringService.hasExceededEnrollment(section);
                Assert.isTrue(!exceededEnrollment, "Section is full");
            }
        }
        return self();
    }
}
