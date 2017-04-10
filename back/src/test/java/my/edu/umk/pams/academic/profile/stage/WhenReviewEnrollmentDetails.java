package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenReviewEnrollmentDetails extends Stage<WhenReviewEnrollmentDetails> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewEnrollmentDetails.class);
	
	@Autowired
	private IdentityService identityService;
	
    @Autowired
    private TermService termService;
    
    @Autowired
    private PlannerService plannerService;
    
    @ExpectedScenarioState
    private AdSection section;
	
    @ExpectedScenarioState
    private AdStudent student;
    
    @ExpectedScenarioState
    private AdCourse course;
    
    @ExpectedScenarioState
    private AdOffering offering;

	public WhenReviewEnrollmentDetails lecturer_review_enrollment_details() {
		
		student = identityService.findStudentByMatricNo("A17P001");	
		LOG.debug("Student's Matric No: {}", student.getMatricNo());
		
		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		LOG.debug("Student's Section Code: {}", section.getCanonicalCode());
		
		offering = termService.findOfferingByCanonicalCode("A01/PHD/0001/DDA2113");
		LOG.debug("Student's Offering Code: {}", offering.getCanonicalCode());
		
		course = plannerService.findCourseByCode("DDA2113");
		LOG.debug("Student's Course(s) : {}", course.getCode());

		return self();
	}

}
