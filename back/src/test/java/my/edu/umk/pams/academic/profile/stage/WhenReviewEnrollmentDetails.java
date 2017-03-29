package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenReviewEnrollmentDetails extends Stage<WhenReviewEnrollmentDetails> {


	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewEnrollmentDetails.class);
	
	@Autowired
	private IdentityService identityService;
	
    @Autowired
    private PlannerService plannerService;
	
    @Autowired
    private TermService termService;
    
    @ExpectedScenarioState
    private AdSection section;
	
    @ExpectedScenarioState
    private AdActor actor;
    
    @ExpectedScenarioState
    private AdOffering offering;

    @ExpectedScenarioState
    private AdProgram program;
      
    @ExpectedScenarioState
    private AdAcademicSession academicSession;
    
    @ProvidedScenarioState
    private List<AdEnrollment> enrollments;
    
    private String SCTN_canonicalCode = "FKP/PHD/0001/DDA2113/201720181";

	@Pending
	public WhenReviewEnrollmentDetails review_enrollment_details() {
    	
		
		
		actor = identityService.findActorByIdentityNo("01001A");
		enrollments = termService.findEnrollments(offering, 0, 100);
		
		for (AdEnrollment enrollment : enrollments) {
			if (enrollment.getSection().equals(SCTN_canonicalCode)) {
				LOG.debug("Student's section: {}", section.getEnrollments());
			}
		}
		
		return self();
	}

}
