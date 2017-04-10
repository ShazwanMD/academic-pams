package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
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

    @ProvidedScenarioState
    private AdCohort cohort;
    
    @ProvidedScenarioState
    private AdProgram program;
    
    @ProvidedScenarioState
    private AdFaculty faculty;
    
	public WhenReviewEnrollmentDetails lecturer_review_enrollment_details() {
		
		student = identityService.findStudentByMatricNo("A17P001");	
		LOG.debug("Student's Matric No: {}", student.getMatricNo());
		
		cohort = plannerService.findCohortByCode("A01/PHD/0001/CHRT/0001");
		LOG.debug("Student's Cohort: {}", cohort.getCode());
		
		program = plannerService.findProgramByCode("A01/PHD/0001");
		LOG.debug("Student's Program: {}", program.getCode());
		
		faculty = plannerService.findFacultyByCode("A01");
		LOG.debug("Student's Faculty: {}", faculty.getCode());

		course = plannerService.findCourseByCode("DDA2113");
		LOG.debug("Student's Course(s) : {}", course.getCode());
		
		offering = termService.findOfferingByCanonicalCode("A01/PHD/0001/DDA2113");
		LOG.debug("Student's Offering Code: {}", offering.getCanonicalCode());
		
		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		LOG.debug("Student's Section Code: {}", section.getCanonicalCode());
		

		return self();
	}

}
