package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author asyikin.mr@umk and ZIANA
 */
@JGivenStage
public class ThenTheOfferingIsReadyForSetup extends Stage<ThenTheOfferingIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenTheOfferingIsReadyForSetup.class);

    @Autowired
    private TermService termService;
    
    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdProgram program;
    
        public ThenTheOfferingIsReadyForSetup the_offering_is_ready_for_setup() {
    	
    	program = plannerService.findProgramByCode("FKP/PHD/0001") ;
    	
        List<AdOffering> offerings = termService.findOfferings(program);
        for (AdOffering offering : offerings) {
            boolean hasSection = termService.hasSection(academicSession, offering);
            Assert.isTrue(!hasSection, "Offering does not have section and ready to be setup");
        }
        return self();
    }
}
